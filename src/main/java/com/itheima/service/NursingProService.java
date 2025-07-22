package com.itheima.service;

import com.itheima.pojo.NursingProject;
import com.itheima.pojo.PageQuery;
import com.itheima.pojo.PageResult;

import java.util.List;

public interface NursingProService {
    PageResult list(PageQuery<NursingProject> pageQuery);
}
