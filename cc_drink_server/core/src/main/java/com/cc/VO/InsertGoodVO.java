package com.cc.VO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author CC
 * @Date 2023/2/14
 */
public class InsertGoodVO {
    @NotBlank(message = "商品名称不能为空！")
    private String name;

    @NotNull(message = "上新状态不能为空！")
    private Integer isPull;

    @NotNull(message = "价格不能为空！")
    private Float price;

    @NotBlank(message = "商品描述不能为空")
    private String description;

    @NotNull(message = "商品分类不能为空")
    private Integer classifyId;

    @NotBlank(message = "图片不能为空！")
    private String img;

    public String getName() {
        return name;
    }

    public Integer getIsPull() {
        return isPull;
    }

    public Float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public String getImg() {
        return img;
    }
}
