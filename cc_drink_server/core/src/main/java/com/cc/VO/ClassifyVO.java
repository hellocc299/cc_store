package com.cc.VO;

import com.cc.entity.Classify;

import java.util.List;

/**
 * @Author CC
 * @Date 2023/2/10
 */
public class ClassifyVO {
    private List<Classify> classifyList;
    private Integer count;

    public ClassifyVO() {
    }

    public List<Classify> getClassifyList() {
        return classifyList;
    }

    public void setClassifyList(List<Classify> classifyList) {
        this.classifyList = classifyList;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
