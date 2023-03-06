package com.cc.controller;

import com.cc.VO.StaffLoginVO;
import com.cc.entity.StaffLogin;
import com.cc.response.R;
import com.cc.service.StaffLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Author CC
 * @Date 2022/10/27
 */

@RestController
@RequestMapping("/staffLogin")
public class StaffLoginController {
    @Autowired
    private StaffLoginService staffLoginService;

    @PostMapping("/addStaffLogin")
    public R addStaffLogin(@RequestBody StaffLogin staffLogin) {
        return staffLoginService.addStaffLogin(staffLogin);
    }

    @PostMapping("/addStaffMenu")
    public R addStaffMenu(@RequestParam String name, @RequestParam String menu) {
        return staffLoginService.addStaffMenu(name, menu);
    }

    @PostMapping(value = "/login")
    public R staffLogin(@RequestBody StaffLoginVO staffLoginVO) {
        return staffLoginService.staffLogin(staffLoginVO);
    }

    @PostMapping("/refresh")
    public R staffLogin(@RequestParam String token, @RequestParam String refreshToken) {
        return staffLoginService.refreshToken(token, refreshToken);
    }

}
