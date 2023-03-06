package com.cc.repository;

import com.cc.entity.StaffLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author CC
 * @Date 2022/10/21
 */

@Repository
public interface StaffLoginRepository extends JpaRepository<StaffLogin, Integer> {
    StaffLogin findStaffLoginByUsername(String username);
}


