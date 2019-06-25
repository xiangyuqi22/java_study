package com.example.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * <PRE>
 * 容器监听(主要用于初始化和销毁数据)该类的方法在一个容器的生命周期内只执行一次
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月18日
 * @author xiangning
 * @since JDK1.8
 */
@WebListener("name=ContextListener")
public class ContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("初始化数据");
		System.out.println("容器启动监听器-开始 -->> listener.ContextListener.contextInitialized(ServletContextEvent)");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("销毁数据");
		System.out.println("容器启动监听器-结束 -->> listener.ContextListener.contextDestroyed(ServletContextEvent)");
	}
	
	
	

}
