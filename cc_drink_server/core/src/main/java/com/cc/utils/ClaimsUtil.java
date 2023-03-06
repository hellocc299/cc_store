package com.cc.utils;

import com.cc.VO.StaffLoginVO;
import com.cc.entity.StaffLogin;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author CC
 * @Date 2022/12/6
 */
public class ClaimsUtil {
    public static Map<String, Object> staffLoginToken2Claim(StaffLoginVO vo) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", vo.getUsername());
        claims.put("password", vo.getPassword());
        return claims;
    }

    public static StaffLoginVO claim2StaffLogin(Map<String , Object> claims) {
        StaffLoginVO vo = new StaffLoginVO();
        String username = vo.getUsername();
        String password = vo.getPassword();
        vo.setUsername(username);
        vo.setPassword(password);
        return vo;
    }

}
