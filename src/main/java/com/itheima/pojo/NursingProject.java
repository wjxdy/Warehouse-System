package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NursingProject {
    private String name;

    private Integer id;

    private Integer orderNo;

    private String unit;

    private BigDecimal price;

    private String image;

    private String nursingRequirement;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;



}
