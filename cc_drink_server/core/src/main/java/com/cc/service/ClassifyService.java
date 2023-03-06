package com.cc.service;

import com.cc.response.R;

public interface ClassifyService {
    R insertClassify(String classify, String imgUrl);

    R findAllClassifies();
}
