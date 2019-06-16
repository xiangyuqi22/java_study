package com.study.springboot.main;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：spring_demo_1</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月5日
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
		logger.info("项目启动成功");
	}

}
