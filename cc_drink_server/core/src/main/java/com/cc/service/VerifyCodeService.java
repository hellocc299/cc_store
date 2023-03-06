package com.cc.service;

import com.cc.response.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface VerifyCodeService {
    /**
     * 创建图片验证码
     * @param response
     * @param request
     * @throws IOException
     */
    void createCode(HttpServletResponse response, HttpServletRequest request) throws IOException;
    /**
     * 检查图片验证码
     * @param
     * @param
     * @throws IOException
     */
    R checkCode(String verificationCode);
}
