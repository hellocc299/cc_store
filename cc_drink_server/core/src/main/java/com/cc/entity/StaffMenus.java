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

@Table(name = "staff_menus")
@DynamicInsert
@DynamicUpdate
@Entity
public class StaffMenus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Integer menuId;

    @Column(nullable = false, length = 20)
    private String menu;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String icon;

    @ManyToMany(mappedBy = "staffMenus")
    @JsonBackReference
    private Set<StaffLogin> staffLogins = new HashSet<StaffLogin>(0);

    @CreationTimestamp
    @Column(nullable = false, name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(nullable = false, name = "update_time")
    private Date updateTime;

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Set<StaffLogin> getStaffLogins() {
        return staffLogins;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonBackReference
    public void setStaffLogins(Set<StaffLogin> staffLogins) {
        this.staffLogins = staffLogins;
    }
}
