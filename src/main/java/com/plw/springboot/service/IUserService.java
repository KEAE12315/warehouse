package com.plw.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.plw.springboot.controller.dto.UserDTO;
import com.plw.springboot.entity.User;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author plw
 * @since 2022-06-23
 */
public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);
}
