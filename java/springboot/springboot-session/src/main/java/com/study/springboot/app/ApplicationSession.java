package com.study.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：spring-session</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年8月23日
 * @author xiangning
 * @since JDK1.8
 */
@SpringBootApplication
@Controller
@ComponentScan("com.study.springboot")
@ServletComponentScan( basePackages = {"com.study.springboot.listener","com.study.springboot.filter"})
public class ApplicationSession {
	
	@RequestMapping("/")
	@ResponseBody
	public String greeting() {
		return "hello world";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationSession.class, args);
	}
	

}
