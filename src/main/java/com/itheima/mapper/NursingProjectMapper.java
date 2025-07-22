package com.itheima.mapper;

import com.itheima.pojo.NursingProject;
import com.itheima.pojo.PageQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NursingProjectMapper{


    List<NursingProject> getList(PageQuery<NursingProject> pageQuery);
};
