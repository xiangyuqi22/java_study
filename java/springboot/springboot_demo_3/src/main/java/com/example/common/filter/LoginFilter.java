package com.example.common.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.utils.StringUtil;

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
@WebFilter(urlPatterns = "/get/*",filterName="login",initParams = {
		@WebInitParam(name="suffix",value=".js")
})
@Order(10)
@Component
public class LoginFilter implements Filter{
	
	private FilterConfig filterConfig;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter.LoginFilter.doFilter(ServletRequest, ServletResponse, FilterChain)");
		String username = request.getParameter("username");
		System.out.println("请求用户名: username = " + username);
		if("spring".equals(username)) {
			chain.doFilter(request, response);
		}else {
			HttpServletResponse rsp = (HttpServletResponse)response;
			rsp.sendRedirect("/html/index.html");
		}
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
