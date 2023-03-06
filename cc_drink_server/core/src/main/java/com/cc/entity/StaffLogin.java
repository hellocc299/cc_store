package com.cc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
 * @Date 2022/10/21
 */
@Table(name = "staff_login")
@DynamicInsert
@DynamicUpdate
@Entity
public class StaffLogin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_login_id")
    private Integer staffLoginId;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name="menu_link",//中间表的名称
            joinColumns={@JoinColumn(name="s_l_id",referencedColumnName="staff_login_id")},
            inverseJoinColumns={@JoinColumn(name="m_id",referencedColumnName="menu_id")}
    )
    private Set<StaffMenus> staffMenus = new HashSet<StaffMenus>(0);

    @CreationTimestamp
    @Column(nullable = false, name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(nullable = false, name = "update_time")
    private Date updateTime;

    public void setStaffLoginId(Integer staffLoginId) {
        this.staffLoginId = staffLoginId;
    }

    public Integer getStaffLoginId() {
        return staffLoginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<StaffMenus> getStaffMenus() {
        return staffMenus;
    }

    @JsonBackReference
    public void setStaffMenus(Set<StaffMenus> staffMenus) {
        this.staffMenus = staffMenus;
    }
}


