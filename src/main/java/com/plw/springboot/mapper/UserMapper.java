package com.plw.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.plw.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
//
//    @Select("select * from sys_user")
//    List<User> findAll();
//
//    @Select("select count(*) from sys_user")
//    Integer selectTotal();
//
//    @Insert("INSERT INTO sys_user VALUES (NULL, #{username}, #{password}, #{nickname}, #{email}, #{phone}, #{address}, default)")
//    int insert(User user);
//
//    int update(User user);
//
//    @Delete("delete from sys_user where id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select * from sys_user limit #{pageNum}, #{pageSize}")
//    List<User> selectPage(Integer pageNum, Integer pageSize);
}
