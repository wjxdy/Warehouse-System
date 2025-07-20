package com.itheima.pojo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserLoginInfo {

    private Integer id;

    private String name;

    private Integer gender;

    private String token;

    private String username;

}
