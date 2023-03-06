package com.cc.service.impl;

import com.cc.Exception.BusinessException;
import com.cc.VO.StaffLoginVO;
import com.cc.constants.JwtConstants;
import com.cc.constants.SuccessConstants;
import com.cc.entity.StaffLogin;
import com.cc.entity.StaffMenus;
import com.cc.repository.StaffLoginRepository;
import com.cc.repository.StaffMenusRepository;
import com.cc.response.ErrorEnum;
import com.cc.response.R;
import com.cc.service.StaffLoginService;
import com.cc.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author CC
 * @Date 2022/10/24
 */
@Service
public class StaffLoginServiceImpl implements StaffLoginService {

    @Autowired
    StaffLoginRepository staffLoginRepository;

    @Autowired
    StaffMenusRepository staffMenusRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public R addStaffLogin(StaffLogin staffLogin) {
        if(staffLogin.getUsername() == null || staffLogin.getPassword() == null) {
            throw new BusinessException(ErrorEnum.E_20018);
        }
        String targetPassword = bCryptPasswordEncoder.encode(staffLogin.getPassword());
        StaffLogin staff = staffLoginRepository.findStaffLoginByUsername(staffLogin.getUsername());
        if(staff != null) {
            throw new BusinessException(ErrorEnum.E_20017);
        }
        staffLogin.setPassword(targetPassword);
        try {
            staffLoginRepository.save(staffLogin);
            return SuccessConstants.OPERATE_SUCCESS;
        } catch (Exception e) {
            throw new BusinessException(ErrorEnum.E_20010);
        }
    }

    @Override
    public R addStaffMenu(String name, String menu) {
        StaffLogin staffLogin = staffLoginRepository.findStaffLoginByUsername(name);
        StaffMenus staffMenu = staffMenusRepository.findStaffMenusByMenu(menu);
        if(staffLogin == null) {
            throw new BusinessException(ErrorEnum.E_20015);
        }
        if(staffMenu == null) {
            throw new BusinessException(ErrorEnum.E_20012);
        }
        if(staffLogin.getStaffMenus().contains(staffMenu)) {
            throw new BusinessException(ErrorEnum.E_20012);
        }
        try {
            staffLogin.getStaffMenus().add(staffMenu);
            staffMenu.getStaffLogins().add(staffLogin);
            staffLoginRepository.save(staffLogin);
            staffMenusRepository.save(staffMenu);
            return SuccessConstants.OPERATE_SUCCESS;
        } catch (Exception e) {
            throw new BusinessException(ErrorEnum.E_20010);
        }
    }

    @Override
    public R staffLogin(StaffLoginVO staffLoginVO) {
        String username = staffLoginVO.getUsername();
        StaffLogin user = staffLoginRepository.findStaffLoginByUsername(username);
        if(user == null) {
            throw new BusinessException(ErrorEnum.E_20015);
        }
        boolean matches = bCryptPasswordEncoder.matches(staffLoginVO.getPassword(), user.getPassword());
        if(!matches) {
            throw new BusinessException(ErrorEnum.E_20016);
        }
        try {
            String accessToken = jwtUtil.generateStaffLoginToken(user);
            String refreshToken = jwtUtil.generateStaffLoginRefreshToken(username);
            Map<String, Object> info = new HashMap<>();
            info.put(JwtConstants.STAFF_LOGIN_INFO, user);
            info.put(JwtConstants.ACCESS_TOKEN, accessToken);
            info.put(JwtConstants.REFRESH_TOKEN, refreshToken);
            return R.success("登录成功", info);
        } catch (Exception e) {
            throw new BusinessException(ErrorEnum.E_20010);
        }
    }

    @Override
    public R refreshToken(String token, String refreshToken) {
        if(!jwtUtil.isTokenExpired(token)) {
            return R.success();
        }
        if(jwtUtil.isTokenExpired(token) && !jwtUtil.isrefreshTokenExpired(refreshToken)) {
            try {
                String accessToken = jwtUtil.refreshStaffToken(token);
                return R.tokenSuccess(accessToken);
            } catch (Exception e) {
                throw new BusinessException(ErrorEnum.E_10000);
            }
        }
        throw new BusinessException(ErrorEnum.E_10000);
    }


}
