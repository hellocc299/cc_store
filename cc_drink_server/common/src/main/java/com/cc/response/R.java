package com.cc.response;

import java.io.Serializable;

/**
 * @Author CC
 * @Date 2022/10/24
 */
public class R implements Serializable {
    private long code;
    private String message;
    private Object data;

    public R() {
    }

    public static R success(){
        R r = new R();
        r.code = 200;
        r.message = null;
        r.data = null;
        return r;
    }

    public static R success(String message){
        R r = new R();
        r.code = 200;
        r.message = message;
        r.data = null;
        return r;
    }

    public static R success(Object data){
        R r = new R();
        r.code = 200;
        r.message = null;
        r.data = data;
        return r;
    }

    public static R success(String message,Object data){
        R r = new R();
        r.code = 200;
        r.message = message;
        r.data = data;
        return r;
    }

    public static R tokenSuccess(String token){
        R r = new R();
        r.code = 200;
        r.message = null;
        r.data = token;
        return r;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
