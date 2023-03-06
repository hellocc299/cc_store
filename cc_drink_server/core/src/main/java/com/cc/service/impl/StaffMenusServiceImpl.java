package com.cc.service.impl;

import com.cc.Exception.BusinessException;
import com.cc.constants.SuccessConstants;
import com.cc.entity.StaffLogin;
import com.cc.entity.StaffMenus;
import com.cc.repository.StaffLoginRepository;
import com.cc.repository.StaffMenusRepository;
import com.cc.response.ErrorEnum;
import com.cc.response.R;
import com.cc.service.StaffMenusService;
import com.cc.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @Author CC
 * @Date 2022/11/15
 */

@Service
public class StaffMenusServiceImpl implements StaffMenusService {
    @Autowired
    private StaffMenusRepository staffMenusRepository;
    
    @Autowired
    private StaffLoginRepository staffLoginRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public R addStaffMenus(StaffMenus menu) {
        StaffMenus staffMenusByMenu = staffMenusRepository.findStaffMenusByMenu(menu.getMenu());
        if(staffMenusByMenu != null) {
            throw new BusinessException(ErrorEnum.E_20012);
        }
        try {
            staffMenusRepository.save(menu);
            return SuccessConstants.OPERATE_SUCCESS;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new BusinessException(ErrorEnum.E_20000);
        }
    }

    @Override
    public R getStaffMenus() {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null) {
            throw new BusinessException(ErrorEnum.E_10000);
        }
        try {
            StaffLogin staffLoginJwt = jwtUtil.getStaffLoginFromToken(token);
            StaffLogin staffLogin = staffLoginRepository.findStaffLoginByUsername(staffLoginJwt.getUsername());
            Set<StaffMenus> staffMenus = staffLogin.getStaffMenus();
            return R.success(staffMenus);
        } catch (Exception e) {
            throw new BusinessException(ErrorEnum.E_20010);
        }

    }
}
