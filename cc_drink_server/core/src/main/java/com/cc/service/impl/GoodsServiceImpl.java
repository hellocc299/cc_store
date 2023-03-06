package com.cc.service.impl;

import com.cc.Exception.BusinessException;
import com.cc.VO.EditGoodsVO;
import com.cc.VO.GoodsVO;
import com.cc.VO.InsertGoodVO;
import com.cc.constants.SuccessConstants;
import com.cc.entity.Classify;
import com.cc.entity.Goods;
import com.cc.entity.GoodsImg;
import com.cc.repository.ClassifyRepository;
import com.cc.repository.GoodsRepository;
import com.cc.repository.GoodsImgRepository;
import com.cc.response.ErrorEnum;
import com.cc.response.R;
import com.cc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * @Author CC
 * @Date 2023/2/3
 */

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;
    
    @Autowired
    private GoodsImgRepository goodsImgRepository;

    @Autowired
    private ClassifyRepository classifyRepository;

    @Override
    public R insertGoods(InsertGoodVO insertGoodVO) {
        Goods goods = new Goods();
        String name = insertGoodVO.getName();
        if(goodsRepository.findGoodsByName(name) != null) {
            throw new BusinessException(ErrorEnum.E_20023);
        }
        Integer isPull = insertGoodVO.getIsPull();
        Float price = insertGoodVO.getPrice();
        String description = insertGoodVO.getDescription();
        Integer classifyId = insertGoodVO.getClassifyId();
        Classify classify = classifyRepository.findClassifyByClassifyId(classifyId);
        if(classify == null) {
            throw new BusinessException(ErrorEnum.E_20027);
        }
        goods.setName(name);
        goods.setIsPull(isPull);
        goods.setPrice(price);
        goods.setDescription(description);
        goods.setClassify(classify);
        String imgUrl = insertGoodVO.getImg();
        GoodsImg goodsImg = goodsImgRepository.findGoodsImgByImgUrl(imgUrl);
        goods.setGoodsImg(goodsImg);
        goodsRepository.save(goods);
        return SuccessConstants.ADD_SUCCESS;
    }

    @Override
    public R findAllGoods() {
        GoodsVO goodsVO = new GoodsVO();
        List<Goods> allGoods = goodsRepository.findAll();
        goodsVO.setGoodsList(allGoods);
        int count = allGoods.size();
        goodsVO.setCount(count);
        return R.success(goodsVO);
    }

    @Override
    public R findGoodsByPage(String name, Integer classfyId, Pageable pageable) {
        if(classfyId == 0) {
            classfyId = null;
        }
        Page<Map<String,Object>> pageList = goodsRepository.findGoodsByCondition2(name, classfyId, pageable);
        Page<Goods> goods = pageList.map(data ->
        Goods.builder()
                        .goodsId(((Integer) data.get("goods_id")).intValue())
                        .name(data.get("name").toString())
                        .isPull(((Integer) data.get("is_pull")).intValue())
                        .price(((Float) data.get("price")).floatValue())
                        .description(data.get("description").toString())
                        .createTime((Date) data.get("create_time"))
                        .updateTime((Date) data.get("update_time"))
                        .classify(Classify.builder()
                                .name(data.get("classify").toString())
                                .imgUrl(data.get("classify_img").toString())
                                .classifyId((Integer) data.get("c_id"))
                                .build())
                        .goodsImg(GoodsImg.builder()
                                .goodsImgId((Integer) data.get("g_i_id"))
                                .imgUrl(data.get("img").toString())
                                .build())
                        .build()
        );

        return R.success(goods);
    }

    @Override
    public R editGoods(EditGoodsVO editGoodsVO) {
        try {
            Optional<Goods> goods = goodsRepository.findById(editGoodsVO.getGoodsId());
            goods.ifPresent(i -> {
                i.setName(editGoodsVO.getName());
                i.setClassify(classifyRepository.findClassifyByClassifyId(editGoodsVO.getClassifyId()));
                i.setIsPull(editGoodsVO.getIsPull());
                i.setDescription(editGoodsVO.getDescription());
                i.setPrice(editGoodsVO.getPrice());
                goodsRepository.save(i);
            });
        } catch (Exception e) {
            throw new BusinessException(ErrorEnum.E_20000);
        }

        return SuccessConstants.UPDATE_SUCCESS;
    }

    @Override
    public R deleteGoods(Integer id) {
        boolean exist = goodsRepository.existsById(id);
        if(exist) {
           goodsRepository.deleteById(id);
        } else {
            throw new BusinessException(ErrorEnum.E_20024);
        }
        return SuccessConstants.DELETE_SUCCESS;
    }

    @Override
    public R getGoodsByClassifyId(Integer classifyId) {
        List<Goods> goods = goodsRepository.findGoodsByClassifyId(classifyId);
        return R.success(goods);
    }
}
