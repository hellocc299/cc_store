package com.cc.service;

import com.cc.entity.StaffMenus;
import com.cc.response.R;

public interface StaffMenusService {
    R addStaffMenus(StaffMenus menus);

    R getStaffMenus();
}
