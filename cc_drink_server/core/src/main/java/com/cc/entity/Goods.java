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
 * @Date 2022/10/24
 */
@Table(name = "goods")
@DynamicInsert
@DynamicUpdate
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Goods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_pull" , nullable = false)
    private Integer isPull;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private String description;

    @ManyToOne(targetEntity=Classify.class)
    @JoinColumn(name="c_id")
    private Classify classify;

    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "g_i_id")
    private GoodsImg goodsImg;

    @CreationTimestamp
    @Column(nullable = false, name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(nullable = false, name = "update_time")
    private Date updateTime;

    public Goods() {

    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsPull() {
        return isPull;
    }

    public void setIsPull(Integer isPull) {
        this.isPull = isPull;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Classify getClassify() {
        return classify;
    }


    public void setClassify(Classify classify) {
        this.classify = classify;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GoodsImg getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(GoodsImg goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Builder
    public Goods(Integer goodsId, String name, Integer isPull, Float price, String description, Classify classify, GoodsImg goodsImg, Date createTime, Date updateTime) {
        this.goodsId = goodsId;
        this.name = name;
        this.isPull = isPull;
        this.description = description;
        this.classify = classify;
        this.price = price;
        this.goodsImg = goodsImg;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

}
