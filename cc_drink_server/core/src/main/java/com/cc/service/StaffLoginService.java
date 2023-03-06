package com.cc.service;

import com.cc.VO.StaffLoginVO;
import com.cc.entity.StaffLogin;
import com.cc.response.R;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

public interface StaffLoginService {
    R addStaffLogin(StaffLogin staffLogin);

    R addStaffMenu(String name, String menu);

    R staffLogin(StaffLoginVO staffLoginVO);

    R refreshToken(String token, String refreshToken);


}
