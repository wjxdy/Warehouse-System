package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.PageQuery;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
