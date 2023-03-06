package com.cc.controller;

import com.cc.entity.StaffMenus;
import com.cc.response.R;
import com.cc.service.StaffMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author CC
 * @Date 2022/11/15
 */
@RestController
@RequestMapping("/staffMenus")
public class StaffMenusController {
    @Autowired
    private StaffMenusService staffMenusService;

    @PostMapping("/addMenus")
    public R addStaffMenus(@RequestBody StaffMenus menus) {
        return staffMenusService.addStaffMenus(menus);
    }

    @GetMapping("/getMenus")
    public R getStaffMenus() { return staffMenusService.getStaffMenus(); }
}
