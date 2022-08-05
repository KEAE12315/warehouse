package com.plw.springboot.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plw.springboot.common.Constants;
import com.plw.springboot.common.Result;
import com.plw.springboot.controller.dto.UserDTO;
import com.plw.springboot.entity.User;
import com.plw.springboot.service.IUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author plw
 * @since 2022-06-23
 */
@RestController
@RequestMapping("/manage/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping
    public Boolean save(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return userService.removeById(id);
    }


    @PostMapping("/del")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return userService.removeByIds(ids);
    }

    @GetMapping("/")
    public List<User> findAll() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public List<User> findOne(@PathVariable Integer id) {
        return (List<User>) userService.getById(id);
    }

    @GetMapping("/username/{username}")
    public Result findOne(@PathVariable String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User one = userService.getOne(queryWrapper);
        if (one != null) {
            return Result.sucess(one);
        } else {
            return Result.error(Constants.CODE_400, "用户不存在");
        }

    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(defaultValue = "") String username, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String address) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if (!"".equals(username)) {
            queryWrapper.like("username", username);
        }
        if (!"".equals(email)) {
            queryWrapper.like("email", email);
        }
        if (!"".equals(address)) {
            queryWrapper.like("address", address);
        }

        return Result.sucess(userService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        List<User> list = userService.list();

        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("用户信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

    @PostMapping("/import")
    public boolean importUser(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<User> users = reader.readAll(User.class);
        userService.saveBatch(users);
        return true;
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        if (StrUtil.isBlank(userDTO.getUsername()) || StrUtil.isBlank(userDTO.getPassword())) {
            return Result.error(Constants.CODE_400, "用户名或密码为空");
        } else {
            return Result.sucess(userService.login(userDTO));
        }

    }

    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO) {
        if (StrUtil.isBlank(userDTO.getUsername()) || StrUtil.isBlank(userDTO.getPassword())) {
            return Result.error(Constants.CODE_400, "注册的用户名或密码为空");
        } else {
            return Result.sucess(userService.register(userDTO));
        }

    }


}
