package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.PageQuery;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.User;
import com.itheima.pojo.UserLoginInfo;
import com.itheima.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;


    @Override
    public PageResult page(PageQuery<User> pageQuery) {
        if (pageQuery.getPageSize()==null){
            pageQuery.setPageSize(5);
        }

        log.info(pageQuery.toString());

       long total= userMapper.count(pageQuery.getT());

        List<User> list= userMapper.list(pageQuery);

        int pages=(int)(total%pageQuery.getPageSize()==0? total/pageQuery.getPageSize():total/pageQuery.getPageSize());


        PageResult pageResult = PageResult.builder()
                .currentPage(pageQuery.getPage())
                .total(total)
                .pages(pages)
                .build();
        pageResult.setData(list);

        return pageResult;

    }

    @Override
    public UserLoginInfo login(User user) throws InvocationTargetException, IllegalAccessException {

       User userInfo=userMapper.login(user);
        if (userInfo!=null){
            UserLoginInfo userLoginInfo=new UserLoginInfo();

            BeanUtils.copyProperties(userLoginInfo,userInfo);
            Map<String, Object> payload =new HashMap<>();
            payload.put("userName",userInfo.getUsername());
            payload.put("name",userInfo.getName());
            String token= JwtUtils.generateJwt(payload);
            userLoginInfo.setToken(token);
            return userLoginInfo;
        }else {
            return null;

        }



    }
}
