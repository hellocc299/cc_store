package com.cc.repository;

import com.cc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByOpenId(String openId);

    User findUserById(Integer id);
}
