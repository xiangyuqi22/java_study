package com.study.couponapp.controller;

import com.study.couponapp.service.ITestService;
import com.study.userserviceapi.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private ITestService iTestService;

    @RequestMapping("/test")
    public String test(){
        return "This is a test!";
    }


    @RequestMapping("/find_user_by_id/{id}")
    public UserVO findUserById(@PathVariable("id")Integer id){
        return iTestService.findUserById(id);
    }

}
