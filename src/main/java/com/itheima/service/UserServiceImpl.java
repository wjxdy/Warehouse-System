package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;




}
