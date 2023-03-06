package com.cc.Exception;

/**
 * @Author CC
 * @Date 2023/2/1
 */

import java.io.Serializable;

/**
 * 自定义处理的返回码
 */
public class ErrorR implements Serializable {
    private String message;
    private Integer code;

    public ErrorR(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
    public static ErrorR create(Integer code, String message) {
        return new ErrorR(code, message);
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
