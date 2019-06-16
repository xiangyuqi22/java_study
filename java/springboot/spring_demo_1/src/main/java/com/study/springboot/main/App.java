package com.study.springboot.main;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@SpringBootApplication
@Controller
@ComponentScan("com.study.springboot")
public class App {
	
	 private static final Logger logger = Logger.getLogger(App.class);
	 
	 @RequestMapping("/")
	 public String greeting() {
		 logger.info("com.study.springboot.main.App.greeting()");
		 return "index";
	 }
	 
	 public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
		logger.info("��Ŀ�����ɹ�");
	}

}
