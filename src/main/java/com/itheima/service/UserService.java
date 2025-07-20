package com.itheima.service;

import com.itheima.pojo.PageQuery;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.User;

public interface UserService {
    PageResult page(PageQuery<User> pageQuery);
}
