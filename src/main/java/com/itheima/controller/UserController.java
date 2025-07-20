package com.itheima.controller;

import com.itheima.pojo.PageQuery;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")


public class UserController {

    private final UserService userService;

    @PostMapping
    public PageResult page(@RequestBody PageQuery<User> pageQuery){

        log.info(pageQuery.toString());

        PageResult pageResult= userService.page(pageQuery);



        return pageResult;
    }


}
