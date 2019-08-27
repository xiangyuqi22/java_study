package com.study.springboot.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * <PRE>
 * session ������,����session�Ĵ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�springboot_demo_3</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��18��
 * @author xiangning
 * @since JDK1.8
 */
@WebListener
public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println("����session");
		System.out.println("��ȡsession id ----> session.getId() = " + session.getId()) ;
		System.out.println("listener.SessionListener.sessionCreated(HttpSessionEvent)");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println("����session");
		System.out.println("��ȡsession id ----> session.getId() = " + session.getId()) ;
		System.out.println("listener.SessionListener.sessionDestroyed(HttpSessionEvent)");
	}
}
