package com.study.userapp.config;

import org.springframework.beans.factory.DisposableBean;

/**
 * @ClassName ShutdownConfig
 * @Description: TODO  优雅关闭时执行  kill -15  优雅关闭
 * @Author xiangning
 * @Date 2019/12/4
 * @Version V1.0
 **/

public class ShutdownConfig implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("优雅关闭服务");
    }
}
