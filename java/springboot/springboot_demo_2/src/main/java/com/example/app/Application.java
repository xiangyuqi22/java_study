package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�springboot_demo_2</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��9��
 * @author xiangning
 * @since JDK1.8
 */
@SpringBootApplication
@Controller
public class Application {
	
	@RequestMapping("/")
	@ResponseBody
	public String greeting() {
		return "hello world";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
