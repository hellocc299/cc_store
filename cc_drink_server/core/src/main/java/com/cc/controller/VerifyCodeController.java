package com.cc.controller;

import com.cc.annotion.LimitRequest;
import com.cc.response.R;
import com.cc.service.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author CC
 * @Date 2022/11/4
 */

@RestController
@RequestMapping("/verify")
public class VerifyCodeController {

    @Autowired
    private VerifyCodeService verifyCodeService;
    /**
     * 获取图片验证码
     */

    @GetMapping("/getCode")
    public void getCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        verifyCodeService.createCode(response, request);
    }

    @PostMapping("/checkCode")
    public R checkCode(String code){
        return verifyCodeService.checkCode(code.toLowerCase());
    }
}

