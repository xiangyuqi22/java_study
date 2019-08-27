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
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�spring-session</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��8��23��
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
			user.setName("���");
			user.setAge(33);
			user.setCreateTime(new Date());
			user.setId(1L);
			user.setPwd("111111");
			user.setGender("��");
			users.add(user);
		}
		{
			User user = new User();
			user.setName("�Ÿ�");
			user.setAge(22);
			user.setCreateTime(new Date());
			user.setId(2L);
			user.setPwd("222222");
			user.setGender("��");
			users.add(user);
		}
		{
			User user = new User();
			user.setName("������");
			user.setAge(18);
			user.setCreateTime(new Date());
			user.setId(3L);
			user.setPwd("333333");
			user.setGender("Ů");
			users.add(user);
		}
		return MessageData.isOK(users);
	}
	

}
