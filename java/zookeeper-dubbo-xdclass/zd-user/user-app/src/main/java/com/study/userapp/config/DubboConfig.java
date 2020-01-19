package com.study.userapp.config;

import org.apache.dubbo.config.MetadataReportConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DubboConfig
 * @Description: TODO  dubbo配置类
 * @Author xiangning
 * @Date 2019/12/3
 * @Version V1.0
 **/
@Configuration
public class DubboConfig {


    @Value("${dubbo.registry.protocol}")
    private String protocol;

    @Value("${dubbo.registry.address}")
    private String host;

    @Bean
    public MetadataReportConfig metadataReportConfig() {
        MetadataReportConfig metadataReportConfig = new
                MetadataReportConfig();
        String address = protocol + "://" + host;
        metadataReportConfig.setAddress(address);
//        metadataReportConfig.setAddress("zookeeper://127.0.0.1:2181");
        return metadataReportConfig;
    }


}
