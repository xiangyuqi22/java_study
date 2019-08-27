package com.study.springboot.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/login")
public class LoginController {
	
	@PostMapping("/in")
	public Object login(HttpServletRequest httpServletRequest , String username , String password) {
		System.out.println(username);
		System.out.println(password);
		
		if("nocjktest".equals(username) && "1".equals(password)) {
			HttpSession session = httpServletRequest.getSession();
			System.out.println(session.getId());
			User user = new User();
			user.setName("���");
			user.setAge(33);
			user.setCreateTime(new Date());
			user.setId(1L);
			user.setPwd("111111");
			user.setGender("��");
			session.setAttribute(session.getId(), user);
			return MessageData.isOK(user);
		} 
		return MessageData.isError("��¼ʧ��");
		
	}
	
	
	@PostMapping("/in2")
	public Object login2(@RequestBody Object object) {
		System.out.println(object.toString());
//		System.out.println(password);
		return MessageData.isError("��¼ʧ��");
		
	}
	
	@PostMapping("/in3")
	public Object login3(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		return MessageData.isError("��¼ʧ��");
		
	}
	
	@PostMapping("/out")
	public Object logOut(HttpServletRequest httpServletRequest) {
		httpServletRequest.getSession().invalidate();
		return MessageData.isOK("�ɹ��˳�");
	}
	
	
	

}
