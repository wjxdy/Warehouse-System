package com.itheima.service;

import com.itheima.mapper.GoodsMapper;
import com.itheima.pojo.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> getAll() {


        List<Goods> goodsList= goodsMapper.getAll();
        log.info(goodsList.toString());

            List<Goods> rankOne=goodsList.stream().filter(goods -> goods.getCatParent()==0).toList();
            log.info(rankOne.toString());
            List<Goods> rankTwo=goodsList.stream().filter(goods -> goods.getCatParent()>0).toList();

            rankOne.forEach(g -> {
                findRankTwo(rankTwo,g);
            });
            log.info(rankOne.toString());

        return rankOne;
    }
    public void findRankTwo(List<Goods> goodsList,Goods  goods){

        List<Goods> rankTwo=goodsList.stream().filter(a -> Objects.equals(a.getCatParent(),goods.getCatId())).collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(rankTwo)){
            goods.getChildren().addAll(rankTwo);
            rankTwo.forEach(goods1 -> {

                findRankTwo(goodsList,goods1);
            });

        }

    }



}
