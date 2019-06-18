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
@WebFilter(urlPatterns = "/get/*" , initParams = {
		@WebInitParam(name="auto",value="login")
})
@Order(20)
@Component
public class AutoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter.AutoFilter.doFilter(ServletRequest, ServletResponse, FilterChain)");
		String password = request.getParameter("password");
		if("boot".equals(password)) {
			chain.doFilter(request, response);
		}else {
			HttpServletResponse rsp = (HttpServletResponse)response;
			rsp.sendRedirect("/html/index.html");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter.AutoFilter.init(FilterConfig)");
		filterConfig.getFilterName();
		Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
		while(initParameterNames.hasMoreElements()) {
			String nextElement = initParameterNames.nextElement();
			System.out.println(nextElement + " --> " + filterConfig.getInitParameter(nextElement));
		}
	}

	@Override
	public void destroy() {
		System.out.println("filter.AutoFilter.destroy()");
	}
	
	
	
	
	

}
