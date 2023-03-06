package com.cc.repository;

import com.cc.entity.StaffMenus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffMenusRepository extends JpaRepository<StaffMenus, Integer> {
    StaffMenus findStaffMenusByMenu(String menu);
}
