package com.cc.controller;

import com.cc.VO.EditGoodsVO;
import com.cc.VO.InsertGoodVO;
import com.cc.response.R;
import com.cc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
/**
 * @Author CC
 * @Date 2023/2/14
 */

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @PostMapping("insertGoods")
    public R insertGood(@RequestBody @Valid InsertGoodVO insertGoodVO) {
        return goodsService.insertGoods(insertGoodVO);
    }

    @GetMapping("findAllGoods")
    public R findAllGoods() {
        return goodsService.findAllGoods();
    }

    @PostMapping("findGoodsByPage")
    public R findGoodsByPage(@RequestParam String name, @RequestParam Integer classifyId, @PageableDefault(page = 0, size = 10)  Pageable pageable) {
        return goodsService.findGoodsByPage(name, classifyId, pageable);
    }

    @PatchMapping("updateGoods")
    public R updateGoods(@RequestBody EditGoodsVO editGoodsVO) {
        return goodsService.editGoods(editGoodsVO);
    }

    @DeleteMapping("deleteGoods")
    public R deleteGoods(@RequestParam Integer id) {
        return goodsService.deleteGoods(id);
    }

    @PostMapping("findGoodsByClassifyId")
    public R findGoodsByClassifyId(@RequestParam Integer id) {
        return goodsService.getGoodsByClassifyId(id);
    }

}
