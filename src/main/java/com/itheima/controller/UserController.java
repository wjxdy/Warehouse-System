package com.itheima.controller;

import com.itheima.pojo.*;
import com.itheima.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@Slf4j
@RequiredArgsConstructor
@RestController



public class UserController {

    private final UserService userService;


    @PostMapping("/login")
    public Result login(@RequestBody User user ) throws InvocationTargetException, IllegalAccessException {

        UserLoginInfo userLoginInfo=userService.login(user);

        Result result= new Result();

        if(userLoginInfo==null){

            result.setMsg("账号或密码错误");
            result.setCode(404);
            return result;

        }
        result.setData(userLoginInfo);
        result.setCode(200);

        return result;

    }



    @PostMapping("/user")
    public PageResult page(@RequestBody PageQuery<User> pageQuery){

        log.info(pageQuery.toString());

        PageResult pageResult= userService.page(pageQuery);



        return pageResult;
    }


}
