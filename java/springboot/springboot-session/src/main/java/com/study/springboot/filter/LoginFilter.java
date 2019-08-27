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
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月17日
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
			System.out.println("登陆失败,没有获取的session对象");
			HttpServletResponse rsp = (HttpServletResponse)response;
			rsp.sendRedirect("/login/in");
		}else {
			System.out.println("成功获取的登陆对象");
			if(object instanceof User ) {
				User  user  = (User)object;
				System.out.println("登陆人:" + user.getName());
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
