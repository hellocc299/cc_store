package com.cc.service;

import com.cc.VO.EditGoodsVO;
import com.cc.VO.InsertGoodVO;
import com.cc.response.R;

import org.springframework.data.domain.Pageable;


public interface GoodsService {
    R insertGoods(InsertGoodVO insertGoodVO);

    R findAllGoods();

    R findGoodsByPage(String name, Integer classifyId, Pageable pageable);

    R editGoods(EditGoodsVO editGoodsVO);

    R deleteGoods(Integer id);

    R getGoodsByClassifyId(Integer classifyId);
}
