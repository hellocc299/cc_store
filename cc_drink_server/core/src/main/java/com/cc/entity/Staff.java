package com.cc.entity;

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

@Table(name = "staff")
@DynamicInsert
@DynamicUpdate
@Entity
public class Staff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String post;

    @Column(nullable = false)
    private Integer age;

    @CreationTimestamp
    @Column(nullable = false, name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(nullable = false, name = "update_time")
    private Date updateTime;
}
