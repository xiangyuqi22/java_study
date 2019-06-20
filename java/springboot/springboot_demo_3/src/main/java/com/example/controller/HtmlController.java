package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
public class HtmlController {
	
	@RequestMapping("/{dir}/{uri}.html")
	public ModelAndView to(@PathVariable("dir")String dir,
			@PathVariable("uri")String uri , 
			String token) {
		String url =  dir + "/" + uri;
		
		ModelAndView modelAndView = new ModelAndView(url);
		
//		String url =  File.separator + dir + File.separator + uri;
		
		return modelAndView;
//		return "back/back";
//		return "templates/back/back.html";
	}
	
	
	@GetMapping("/{path}.html")
	public String to1(@PathVariable("path")String path,
			String token) {
		
		System.out.println(token);
		
		return path;
	}
	
	@GetMapping("/hello2")
	public String to2(
			String token) {
		
		System.out.println(token);
		
		return "hello";
	}
	
	
	@GetMapping("/hello1")
	public ModelAndView  to3(
			String token) {
		System.out.println(token);
		
		return new ModelAndView("hello");
	}

}
