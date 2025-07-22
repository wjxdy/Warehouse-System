package com.itheima.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.NursingProjectMapper;
import com.itheima.pojo.NursingProject;
import com.itheima.pojo.PageQuery;
import com.itheima.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NursingProServiceImpl implements NursingProService{
    @Autowired
    NursingProjectMapper nursingProjectMapper;


    @Override
    public PageResult list(PageQuery<NursingProject> pageQuery) {
        if(pageQuery.getPage()==null||pageQuery.getPage()<1){
            pageQuery.setPage(1);
        }
        if (pageQuery.getPageSize()==null||pageQuery.getPageSize()<1){
            pageQuery.setPageSize(5);

        }
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getPageSize());

        NursingProject t = pageQuery.getT();
        if (t != null) {
            t.setUpdateTime(LocalDateTime.now());
        }
        Page<NursingProject> page=(Page<NursingProject>)nursingProjectMapper.getList(pageQuery);

        PageResult result = new PageResult(page.getTotal(), page.getPages(), pageQuery.getPage());
        result.setData(page.getResult());

        return result;
    }
}
