package com.study.springboot.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.study.springboot.bean.User;


/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�springboot_demo_3</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��17��
 * @author xiangning
 * @since JDK1.8
 */
@WebFilter(urlPatterns = "/user/*",filterName="login")
public class LoginFilter implements Filter{
	
	private FilterConfig filterConfig;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpSession session = httpServletRequest.getSession();
		Object object = session.getAttribute(session.getId());
		System.out.println("sessionId = " + session.getId());
		if(object == null) {
			System.out.println("��½ʧ��,û�л�ȡ��session����");
			HttpServletResponse rsp = (HttpServletResponse)response;
			rsp.sendRedirect("/login/in");
		}else {
			System.out.println("�ɹ���ȡ�ĵ�½����");
			if(object instanceof User ) {
				User  user  = (User)object;
				System.out.println("��½��:" + user.getName());
			}
			chain.doFilter(request, response);
		}
		
		/*if("spring".equals(username)) {
		}else {
			HttpServletResponse rsp = (HttpServletResponse)response;
			rsp.sendRedirect("/html/login.html");
		}*/
//		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter.LoginFilter.init(FilterConfig)");
		this.filterConfig = filterConfig;
		filterConfig.getFilterName();
		Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
		while(initParameterNames.hasMoreElements()) {
			String nextElement = initParameterNames.nextElement();
			System.out.println(nextElement + " --> " + filterConfig.getInitParameter(nextElement));
		}
	}

	@Override
	public void destroy() {
		System.out.println("filter.LoginFilter.destroy()");
	}
	
}
