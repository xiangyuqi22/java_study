package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User2;
import com.example.data.MessageData;
import com.example.service.User2Service;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月25日
 * @author xiangning
 * @since JDK1.8
 */
@RestController
@RequestMapping("/user2")
public class User2Controller {
	
	@Autowired
	private User2Service user2Service;
	
	@RequestMapping("/insert")
	public Object insert(User2 user) {
		System.out.println(user.toString());
		user.setCreateTime(new Date());
		Integer insert = user2Service.insert(user);
		return MessageData.isOK(insert);
	}

}
