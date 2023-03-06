package com.cc.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author CC
 * @Date 2023/2/17
 */
@Configuration
public class FilePathUtil implements WebMvcConfigurer {

    @Value("${web.upload-path}")
    private String localtion;

    @Value("${web.show}")
    private String show;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(show) // 虚拟url路径
                .addResourceLocations("file:" + localtion); // 真实本地路径
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
