package com.example.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月11日
 * @author xiangning
 * @since JDK1.8
 */
@RestController
@RequestMapping("/json")
public class JsonController {
	
	@GetMapping("/all")
	public Object getAll() {
		User user = new User();
		user.setAge(19);
		user.setCreateTime(new Date());
		user.setGender("男");
		user.setId(1989L);
		user.setName("李白");
		user.setPwd("1234567889");
		return user;
	}
	
	@GetMapping("/not_age")
	public Object getNotAge() {
		User user = new User();
		user.setCreateTime(new Date());
		user.setGender("男");
		user.setId(1989L);
		user.setName("李白");
		user.setPwd("1234567889");
		return user;
	}
	
	@GetMapping("/empty_name")
	public Object getEmptyName() {
		User user = new User();
		user.setAge(19);
		user.setCreateTime(new Date());
		user.setGender("男");
		user.setId(1989L);
		user.setName("");
		user.setPwd("1234567889");
		return user;
	}
	
	@GetMapping("/null_name")
	public Object getNullName() {
		User user = new User();
		user.setAge(19);
		user.setCreateTime(new Date());
		user.setGender("男");
		user.setId(1989L);
		user.setPwd("1234567889");
		return user;
	}
	

}
