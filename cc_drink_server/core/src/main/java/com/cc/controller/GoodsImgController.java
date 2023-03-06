package com.cc.controller;

import com.cc.entity.GoodsImg;
import com.cc.repository.GoodsImgRepository;
import com.cc.response.R;
import com.cc.service.FileService;
import com.cc.service.GoodsImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * @Author CC
 * @Date 2023/1/31
 */
@RequestMapping("goodsImg")
@Controller
public class GoodsImgController {

    @Autowired
    private FileService fileService;

    @Autowired
    private GoodsImgRepository goodsImgRepository;

    @Autowired
    private GoodsImgService goodsImgService;

    @PostMapping("insertImg")
    @ResponseBody
    public R insertImg(@RequestParam("file") MultipartFile file) {
        String url = fileService.uploadImg(file);
        GoodsImg goodsImg = new GoodsImg();
        goodsImg.setImgUrl(url);
        goodsImgRepository.save(goodsImg);
        return R.success(null, url);
    }

    @PostMapping("uploadImg")
    @ResponseBody
    public R uploadImg(@RequestParam("file") MultipartFile file) {
        String url = fileService.uploadImg(file);
        return R.success(null, url);
    }

    @PatchMapping("updateImg")
    @ResponseBody
    public R updateImg(@RequestParam Integer imgId, @RequestParam  String imgUrl) {
        return goodsImgService.updateImg(imgId, imgUrl);
    }
}
