package com.cc.annotion;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD) // 说明该注解只能放在方法上面
@Retention(RetentionPolicy.RUNTIME)
public @interface LimitRequest {
    long time() default 6000; // 限制时间 单位：毫秒
    int count() default 3; // 允许请求的次数
}