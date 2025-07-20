package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQuery<T> {

    private  T t;

    private Integer page;

    private Integer pageSize;

    private Integer index;


    public Integer getIndex(){
        if (page == null) {
            page = 1;
        }

       return  (page-1)*pageSize;
    }
}
