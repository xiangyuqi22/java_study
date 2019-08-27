package com.study.springboot.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


/**
 * <PRE>
 * 请求监听器(生命周期在一个请求开始和结束之间,不在容器启动和关闭时),
 * 容器启动时创建对象
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月18日
 * @author xiangning
 * @since JDK1.8
 */
@WebListener()
public class RequestListener implements ServletRequestListener{
	
	
	public RequestListener() {
//		System.out.println("创建请求监听");
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
//		System.out.println("请求结束");
	}

	

}
