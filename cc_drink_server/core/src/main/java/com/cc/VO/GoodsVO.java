package com.cc.VO;

import com.cc.entity.Goods;

import java.util.List;

/**
 * @Author CC
 * @Date 2023/2/15
 */
public class GoodsVO {
    private List<Goods> goodsList;
    private Integer count;

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
