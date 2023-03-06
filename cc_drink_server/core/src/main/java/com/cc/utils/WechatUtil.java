package com.cc.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cc.Exception.BusinessException;
import com.cc.response.ErrorEnum;
import org.apache.http.client.utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author CC
 * @Date 2023/2/19
 */
public class WechatUtil {
    @Value("${web.wx-request}")
    public static String requestUrl;

    @Value("${web.app-id}")
    public static String appId;

    @Value("${web.secret}")
    public static String appSecret;

    public static JSONObject getSessionKeyOrOpenId(String code) {
        Map<String, String> requestUrlParam = new HashMap<>();
        //小程序appId
        requestUrlParam.put("appid", appId);
        //小程序secret
        requestUrlParam.put("secret", appSecret);
        //小程序端返回的code
        requestUrlParam.put("js_code", code);
        //默认参数
        requestUrlParam.put("grant_type", "authorization_code");
        //发送post请求读取调用微信接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(HttpClientUtil.doPost(requestUrl, requestUrlParam));
        return jsonObject;
    }

    /**
     * 获取制定小程序的accesstoken
     * @param tokenUrl 获取该 token的链接
     * @return
     */
    public static String getAccessToken(String tokenUrl){
        String s = HttpClientUtil.doGet(tokenUrl);
        if(s == null){
            throw new BusinessException(ErrorEnum.E_20029);
        }
        JSONObject result = JSONObject.parseObject(s);
        return result.getString("access_token");
    }


}
