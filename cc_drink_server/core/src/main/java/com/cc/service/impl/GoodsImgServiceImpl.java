package com.cc.service.impl;

import com.cc.entity.GoodsImg;
import com.cc.repository.GoodsImgRepository;
import com.cc.response.R;
import com.cc.service.GoodsImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author CC
 * @Date 2023/2/17
 */
@Service
public class GoodsImgServiceImpl implements GoodsImgService {
    @Autowired
    private GoodsImgRepository goodsImgRepository;
    @Override
    public R updateImg(Integer imgId, String imgUrl) {
        goodsImgRepository.updateGoodsImg(imgUrl, imgId);
        return R.success();
    }
}
