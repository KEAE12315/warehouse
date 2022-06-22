package com.plw.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plw.springboot.entity.User;
import com.plw.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
