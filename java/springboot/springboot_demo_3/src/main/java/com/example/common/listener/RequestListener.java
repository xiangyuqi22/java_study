package com.example.common.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.config.ServletSettings;

/**
 * <PRE>
 * 请求监听器(生命周期在一个请求开始和结束之间,不在容器启动和关闭时)
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
	
	@Autowired
	private ServletSettings set;

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		ServletRequest servletRequest = sre.getServletRequest();
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		request.getSession();
		System.out.println("请求开始");
		System.out.println(set.getDomain());
		Object name = servletRequest.getParameter("name");
		if( name != null) {
			System.out.println("requestDestroyed.name = " + name.toString());
		}
		System.out.println("com.example.common.listener.RequestListener.requestInitialized(ServletRequestEvent)");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		ServletRequest servletRequest = sre.getServletRequest();
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		request.getSession().invalidate();
		System.out.println("请求结束");
		System.out.println("listener.RequestListener.requestDestroyed(ServletRequestEvent)");
	}

	

}
