package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer catId;
    private String catName;
    private Integer catParent;
    private Integer catRank;
    private List<Goods> children=new ArrayList<>();
}
