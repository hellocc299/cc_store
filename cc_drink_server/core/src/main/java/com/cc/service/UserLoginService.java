package com.cc.service;

import com.cc.response.R;

public interface UserLoginService {
    R getPhoneNumber(String code);

    R wxLogin(String code, String rawData, String signature);
}
