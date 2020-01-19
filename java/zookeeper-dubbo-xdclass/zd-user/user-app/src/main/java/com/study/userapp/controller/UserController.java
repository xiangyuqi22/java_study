package com.study.userapp.controller;

import com.study.userserviceapi.service.IUserService;
import com.study.userserviceapi.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author xiangning
 * @Date 2019/12/3
 * @Version V1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;


    @RequestMapping("/find_user_by_id/{id}")
    public UserVO findUserById(@PathVariable("id") int id){
        UserVO userVO = iUserService.findUserById(id);
        return userVO;
    }

}
