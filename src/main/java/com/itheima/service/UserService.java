package com.itheima.service;

import com.itheima.pojo.PageQuery;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.User;
import com.itheima.pojo.UserLoginInfo;

import java.lang.reflect.InvocationTargetException;

public interface UserService {
    PageResult page(PageQuery<User> pageQuery);

    UserLoginInfo login(User user) throws InvocationTargetException, IllegalAccessException;
}
