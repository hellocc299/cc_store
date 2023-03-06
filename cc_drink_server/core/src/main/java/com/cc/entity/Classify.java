package com.cc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author CC
 * @Date 2022/10/24
 */

@Table(name = "classify")
@DynamicInsert
@DynamicUpdate
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Classify implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classify_id")
    private Integer classifyId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "img_url")
    private String imgUrl;

    @OneToMany(targetEntity = Goods.class)
    @JoinColumn(name = "c_id")
    private Set<Goods> goods = new HashSet<Goods>(0);

    @CreationTimestamp
    @Column(nullable = false, name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(nullable = false, name = "update_time")
    private Date updateTime;

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Set<Goods> getGoods() {
        return goods;
    }

    @JsonBackReference
    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Classify() {
    }

    @Builder
    public Classify(Integer classifyId, String name, String imgUrl) {
        this.classifyId = classifyId;
        this.name = name;
        this.imgUrl = imgUrl;
    }
}
