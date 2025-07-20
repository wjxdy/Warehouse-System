package com.itheima.mapper;

import com.itheima.pojo.PageQuery;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    long count(User t);

    List<User> list(PageQuery<User> pageQuery);


    @Select("select * from user where username=#{username} and password=#{password}")
    User login(User user);
}
