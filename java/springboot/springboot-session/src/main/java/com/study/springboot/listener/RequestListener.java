package com.study.springboot.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


/**
 * <PRE>
 * ���������(����������һ������ʼ�ͽ���֮��,�������������͹ر�ʱ),
 * ��������ʱ��������
 * </PRE>
 *
 * ��Ŀ���ƣ�springboot_demo_3</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��18��
 * @author xiangning
 * @since JDK1.8
 */
@WebListener()
public class RequestListener implements ServletRequestListener{
	
	
	public RequestListener() {
//		System.out.println("�����������");
	}
	

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
//		ServletRequest servletRequest = sre.getServletRequest();
//		HttpServletRequest request = (HttpServletRequest)servletRequest;
//		request.getSession();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
//		ServletRequest servletRequest = sre.getServletRequest();
//		HttpServletRequest request = (HttpServletRequest)servletRequest;
//		System.out.println("�������");
	}

	

}
