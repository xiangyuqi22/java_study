package com.example.common.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * <PRE>
 * servlet3.0原生的servlet  
 * 该请求在filter拦截之前
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月18日
 * @author xiangning
 * @since JDK1.8
 */
@WebServlet(
		name = "helloServlet",
		urlPatterns = {"/hello_servlet1" ,  "/hello_servlet2" , "/get/*"} , 
		initParams = {
			@WebInitParam(name="say",value="hello"),
			@WebInitParam(name="init",value="param")
		},
		loadOnStartup = 2
)
@Component
public class HelloSelvet extends HttpServlet{
	
	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet.HelloSelvet.init(ServletConfig)");
		this.config = config;
		super.init(config);
		Enumeration<String> initParameterNames = config.getInitParameterNames();
		while(initParameterNames.hasMoreElements()) {
			String nextElement = initParameterNames.nextElement();
			System.out.println(config.getInitParameter(nextElement));
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet.HelloSelvet.doGet(HttpServletRequest, HttpServletResponse)");
		PrintWriter writer = resp.getWriter();
		Enumeration<String> initParameterNames = config.getInitParameterNames();
		while(initParameterNames.hasMoreElements()) {
			String nextElement = initParameterNames.nextElement();
			writer.println(config.getInitParameter(nextElement));
		}
		writer.flush();
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	

}
