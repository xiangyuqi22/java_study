package com.example.common.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.stereotype.Component;

/**
 * <PRE>
 * session 监听器,监听session的创建和销毁
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月18日
 * @author xiangning
 * @since JDK1.8
 */
@WebListener
public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
//		session.invalidate();
//		session.setMaxInactiveInterval(10);
		System.out.println("创建session");
		System.out.println("获取session id ----> session.getId() = " + session.getId()) ;
		System.out.println("listener.SessionListener.sessionCreated(HttpSessionEvent)");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println("销毁session");
		System.out.println("获取session id ----> session.getId() = " + session.getId()) ;
		System.out.println("listener.SessionListener.sessionDestroyed(HttpSessionEvent)");
	}
}
