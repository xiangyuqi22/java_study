package com.study.springboot.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.interceptor.ErrorInterceptor;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�spring_demo_1</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��5��
 * @author xiangning
 * @since JDK1.8
 */
@Controller
public class HelloController {

	 private static final Logger logger = Logger.getLogger(HelloController.class);

	@RequestMapping("/hello")
    public String greeting(ModelMap map) {
		logger.info("com.study.springboot.controller.HelloController.greeting(ModelMap)");
        map.addAttribute("name", "ģ������");
        map.addAttribute("host", "���Գɹ�");
        return "hello";
    }

}
