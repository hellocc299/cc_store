package com.cc.utils;

import java.util.UUID;

/**
 * @Author CC
 * @Date 2023/1/31
 */
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
