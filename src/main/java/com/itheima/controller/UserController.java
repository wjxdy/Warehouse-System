package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")


public class UserController {
    private final UserService userService;




}
