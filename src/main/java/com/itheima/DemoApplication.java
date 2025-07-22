package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args){

        SpringApplication.run(DemoApplication.class,args);

    }
}
