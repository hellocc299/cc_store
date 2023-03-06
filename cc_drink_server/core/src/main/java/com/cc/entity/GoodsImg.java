package com.cc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author CC
 * @Date 2023/1/31
 */
@Table(name = "goods_img")
@DynamicInsert
@DynamicUpdate
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class GoodsImg implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_img_id")
    private Integer goodsImgId;

    @Column(name="img_url", nullable = false)
    private String imgUrl;

    @OneToOne(mappedBy="goodsImg",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "g_i_id")
    private Goods goods;

    @CreationTimestamp
    @Column(nullable = false, name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(nullable = false, name = "update_time")
    private Date updateTime;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getGoodsImgId() {
        return goodsImgId;
    }

    public void setGoodsImgId(Integer goodsImgId) {
        this.goodsImgId = goodsImgId;
    }

    public GoodsImg() {
    }

    @Builder
    public GoodsImg(Integer goodsImgId, String imgUrl) {
        this.goodsImgId = goodsImgId;
        this.imgUrl = imgUrl;
    }
}
