package com.cc.service.impl;

import com.cc.Exception.BusinessException;
import com.cc.response.ErrorEnum;
import com.cc.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * @Author CC
 * @Date 2023/2/18
 */
@Service
public class FileServiceImpl implements FileService {
    private final ResourceLoader resourceLoader;

    public FileServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String localtion;

    @Value("${web.host}")
    private String host;


    @Override
    public String uploadImg(MultipartFile file) {
        //获得文件的后缀
        String filename = UUID.randomUUID() + Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
        //获取文件存储路径
        File filepath = new File(localtion + filename);
        try {
            //存文件
            file.transferTo(filepath);
            String imgUrl = host + filename;
            return imgUrl;
        } catch (IOException e) {
            throw new BusinessException(ErrorEnum.E_20022);
        }
    }
}
