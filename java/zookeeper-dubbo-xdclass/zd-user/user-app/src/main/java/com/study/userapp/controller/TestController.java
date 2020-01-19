package com.study.userapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description: TODO  测试控制器接口
 * @Author xiangning
 * @Date 2019/11/29
 * @Version V1.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "This is a test!";
    }

}
