package com.study.springboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.bean.User;
import com.study.springboot.utils.MessageData;

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
@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/list")
	public Object getUserList() {
		List<User> users = new ArrayList<>();
		{
			User user = new User();
			user.setName("李白");
			user.setAge(33);
			user.setCreateTime(new Date());
			user.setId(1L);
			user.setPwd("111111");
			user.setGender("男");
			users.add(user);
		}
		{
			User user = new User();
			user.setName("杜甫");
			user.setAge(22);
			user.setCreateTime(new Date());
			user.setId(2L);
			user.setPwd("222222");
			user.setGender("男");
			users.add(user);
		}
		{
			User user = new User();
			user.setName("李清照");
			user.setAge(18);
			user.setCreateTime(new Date());
			user.setId(3L);
			user.setPwd("333333");
			user.setGender("女");
			users.add(user);
		}
		return MessageData.isOK(users);
	}
	

}
