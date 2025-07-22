package com.itheima.controller;

import com.itheima.pojo.NursingProject;
import com.itheima.pojo.PageQuery;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.NursingProService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RequestMapping("/nursing")

@RestController
public class NursingProjectcontroller {
    @Autowired
    private NursingProService nursingProService;

    @GetMapping("/list")
    public Result list(PageQuery<NursingProject> pageQuery){
        log.info("接口被调用");



//        try {
            PageResult pageNurList= nursingProService.list(pageQuery);
            pageNurList.setCode(200);


            return pageNurList;
//
//        } catch (Exception e) {
//
//            return new Result(401,null,"请求有问题");
//
//        }


    }


}
