package com.cc.utils;

import com.alibaba.fastjson.JSONObject;
import com.cc.response.ErrorEnum;
import com.mysql.cj.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * @Author CC
 * @Date 2023/2/1
 */
public class CommonUtil {
    /**
     * 返回错误信息JSON
     *
     * @param errorEnum 错误码的errorEnum
     * @return
     */
    public static JSONObject errorJson(ErrorEnum errorEnum) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("returnCode", errorEnum.getErrorCode());
        resultJson.put("returnMsg", errorEnum.getErrorMsg());
        resultJson.put("returnData", new JSONObject());
        return resultJson;
    }

    /**
     * 将request参数值转为json
     *
     * @param request
     * @return
     */
    public static JSONObject request2Json(HttpServletRequest request) {
        JSONObject requestJson = new JSONObject();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] pv = request.getParameterValues(paramName);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pv.length; i++) {
                if (pv[i].length() > 0) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(pv[i]);
                }
            }
            requestJson.put(paramName, sb.toString());
        }
        return requestJson;
    }
}

