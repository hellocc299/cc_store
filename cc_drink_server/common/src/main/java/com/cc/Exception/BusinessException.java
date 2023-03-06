package com.cc.Exception;

import com.alibaba.fastjson.JSONObject;
import com.cc.response.ErrorEnum;
import com.cc.utils.CommonUtil;

/**
 * @Author CC
 * @Date 2023/2/1
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private JSONObject resultJson;
    /**
     * @param errorEnum 以错误的ErrorEnum做参数
     */
    public BusinessException(ErrorEnum errorEnum) {
        super(errorEnum.getErrorMsg());
        this.code = errorEnum.getErrorCode();
        this.resultJson = CommonUtil.errorJson(errorEnum);
    }

    public BusinessException(JSONObject resultJson) {
        this.resultJson = resultJson;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}