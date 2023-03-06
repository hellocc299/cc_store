package com.cc.service.impl;

import com.cc.Exception.BusinessException;
import com.cc.VO.ClassifyVO;
import com.cc.constants.SuccessConstants;
import com.cc.entity.Classify;
import com.cc.repository.ClassifyRepository;
import com.cc.response.ErrorEnum;
import com.cc.response.R;
import com.cc.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author CC
 * @Date 2023/2/9
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyRepository classifyRepository;

    @Override
    public R insertClassify(String name, String imgUrl) {
        if(imgUrl == null) {
            throw new BusinessException(ErrorEnum.E_20021);
        }
        if(name == null) {
            throw new BusinessException(ErrorEnum.E_20026);
        }
        Classify classify = classifyRepository.findClassifyByName(name);
        if(classify != null) {
            throw new BusinessException(ErrorEnum.E_20025);
        }
        Classify newClassify = new Classify();
        newClassify.setName(name);
        newClassify.setImgUrl(imgUrl);
        classifyRepository.save(newClassify);
        return SuccessConstants.ADD_SUCCESS;
    }

    @Override
    public R findAllClassifies() {
        List<Classify> classifies = classifyRepository.findAll();
        int count = classifies.size();
        ClassifyVO classifyVO = new ClassifyVO();
        classifyVO.setClassifyList(classifies);
        classifyVO.setCount(count);
        return R.success(classifyVO);
    }
}
