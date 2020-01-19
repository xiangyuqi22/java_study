package com.study.couponapp.service.impl;

import com.study.couponapp.service.ITestService;
import com.study.userserviceapi.service.IUserService;
import com.study.userserviceapi.vo.UserVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @ClassName TestServiceImpl
 * @Description: TODO
 * @Author xiangning
 * @Date 2019/12/3
 * @Version V1.0
 **/
@Service
public class TestServiceImpl implements ITestService {

    //这里必须要引入 dubbo的 org.apache.dubbo.config.annotation.Reference
    @Reference
    private IUserService iUserService;

    @Override
    public UserVO findUserById(Integer id) {
        return iUserService.findUserById(id);
    }
}
