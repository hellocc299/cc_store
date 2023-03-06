package com.cc.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String uploadImg(MultipartFile file);
}
