package com.cc.repository;

import com.cc.entity.Classify;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClassifyRepository extends JpaRepository<Classify, Integer>{
    Classify findClassifyByName(String classify);

    Classify findClassifyByClassifyId(Integer classifyId);
}
