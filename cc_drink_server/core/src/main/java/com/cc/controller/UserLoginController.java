package com.cc.controller;

import com.cc.response.R;
import com.cc.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author CC
 * @Date 2023/2/19
 */

@RestController
@RequestMapping("wx")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("login")
    @ResponseBody
    public R userWxLogin(@RequestParam(value = "code") String code,
                         @RequestParam(value = "avatarUrl") String avatarUrl,
                         @RequestParam(value = "nickName") String nickName) {
        return userLoginService.wxLogin(code, avatarUrl, nickName);
    }
}
