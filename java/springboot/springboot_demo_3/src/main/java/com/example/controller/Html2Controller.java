package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月20日
 * @author xiangning
 * @since JDK1.8
 */
@Controller
public class Html2Controller {
	
	@RequestMapping("/hello")
	public String greeting(ModelMap map) {
		return "hello";
	}

}
