package com.cc.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cc.Exception.BusinessException;
import com.cc.constants.JwtConstants;
import com.cc.entity.User;
import com.cc.repository.UserRepository;
import com.cc.response.ErrorEnum;
import com.cc.response.R;
import com.cc.service.UserLoginService;
import com.cc.utils.HttpClientUtil;
import com.cc.utils.JwtUtil;
import com.cc.utils.WechatUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author CC
 * @Date 2023/2/19
 */

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${web.app-id}")
    private String appId;

    @Value("${web.app-secret}")
    private String appSecret;

    @Override
    public R getPhoneNumber(String code) {
        // 获取token
        String token_url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", WechatUtil.appId, WechatUtil.appSecret);
        JSONObject token = JSON.parseObject(HttpUtil.get(token_url));
        // 使用前端code获取手机号码 参数为json格式
        String url = "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=" + token.getString("access_token");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("code", code);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(paramMap, headers);
        ResponseEntity<Object> response = restTemplate.postForEntity(url, httpEntity, Object.class);
        return R.success(response.getBody());
    }

    @Override
    public R wxLogin(String code, String avatarUrl, String nickName) {
        String getOpenidUrl = String.format("https://api.weixin.qq.com/sns/jscode2session?grant_type=client_credential&appid=%s&secret=%s&js_code=%s", appId, appSecret, code);
        JSONObject res = JSON.parseObject(HttpUtil.get(getOpenidUrl));
        String openid = res.getString("openid");
        User user = userRepository.findUserByOpenId(openid);
        if(user == null) {
            user = new User();
            user.setOpenId(openid);
            user.setAvatarUrl(avatarUrl);
            user.setNickName(nickName);
            userRepository.save(user);
        }
        String accessToken = jwtUtil.generateUserToken(user);
        String refreshToken = jwtUtil.generateUserRefreshToken(user.getOpenId());
        Map<String, Object> info = new HashMap<>();
        info.put(JwtConstants.WX_LOGIN_INFO, user);
        info.put(JwtConstants.ACCESS_TOKEN, accessToken);
        info.put(JwtConstants.REFRESH_TOKEN, refreshToken);
        return R.success(info);
    }
}
