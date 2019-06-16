package com.example.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月9日
 * @author xiangning
 * @since JDK1.8
 */
@EnableAutoConfiguration
@RestController("/auto")
public class AutoController {
	
	@RequestMapping("/auto")
	public String greeting() {
		return "com.example.controller.AutoController.greeting()";
	}

}
