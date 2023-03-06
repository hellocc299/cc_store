package com.cc.VO;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author CC
 * @Date 2023/2/17
 */
public class EditGoodsVO {
    private Integer goodsId;
    private String name;
    private Integer classifyId;
    private Integer isPull;
    private String description;
    private Float price;

    public Integer getGoodsId() {
        return goodsId;
    }

    public String getName() {
        return name;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public Integer getIsPull() {
        return isPull;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }
}
