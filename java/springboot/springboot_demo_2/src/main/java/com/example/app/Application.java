package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot_demo_2</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月9日
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
