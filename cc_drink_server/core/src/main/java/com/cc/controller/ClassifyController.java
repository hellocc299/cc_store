package com.cc.controller;

import com.cc.response.R;
import com.cc.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author CC
 * @Date 2023/2/9
 */

@RestController
@RequestMapping("classify")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;

    @PostMapping("insertClassify")
    public R insertClassify(@RequestParam String classify, @RequestParam String imgUrl) {
        return classifyService.insertClassify(classify, imgUrl);
    }

    @GetMapping("findAllClassifies")
    public R findAllClassifies() {
        return classifyService.findAllClassifies();
    }
}
