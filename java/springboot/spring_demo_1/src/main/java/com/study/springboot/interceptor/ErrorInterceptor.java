package com.study.springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * <PRE>
 * ������
 * </PRE>
 *
 * ��Ŀ���ƣ�spring_demo_1</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��5��
 * @author xiangning
 * @since JDK1.8
 */
public class ErrorInterceptor implements HandlerInterceptor {
	
	 private static final Logger logger = Logger.getLogger(ErrorInterceptor.class);

	 /**  
     * preHandle�����ǽ��д����������õģ�����˼�壬�÷�������Controller����֮ǰ���е��ã�SpringMVC�е�Interceptor����������ʽ�ģ�����ͬʱ����  
     * ���Interceptor��Ȼ��SpringMVC�����������ǰ��˳��һ����һ����ִ�У��������е�Interceptor�е�preHandle����������  
     * Controller��������֮ǰ���á�SpringMVC������Interceptor��ʽ�ṹҲ�ǿ��Խ����жϵģ������жϷ�ʽ����preHandle�ķ�  
     * ��ֵΪfalse����preHandle�ķ���ֵΪfalse��ʱ����������ͽ����ˡ�  
     */    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  
            throws Exception {  
    	logger.info("com.study.springboot.interceptor.ErrorInterceptor.preHandle(HttpServletRequest, HttpServletResponse, Object)");
        return true;// ֻ�з���true�Ż��������ִ�У�����falseȡ����ǰ����  
    }  
  
    /**  
     * �������ֻ���ڵ�ǰ���Interceptor��preHandle��������ֵΪtrue��ʱ��Ż�ִ�С�postHandle�ǽ��д����������õģ�����ִ��ʱ�����ڴ��������д���֮  
     * ��Ҳ������Controller�ķ�������֮��ִ�У�����������DispatcherServlet������ͼ����Ⱦ֮ǰִ�У�Ҳ����˵���������������Զ�ModelAndView���в�  
     * ���������������ʽ�ṹ���������ʵķ������෴�ģ�Ҳ����˵��������Interceptor�������÷������������ã����Struts2�������������ִ�й����е���  
     * ֻ��Struts2�����intercept������Ҫ�ֶ��ĵ���ActionInvocation��invoke������Struts2�е���ActionInvocation��invoke�������ǵ�����һ��Interceptor  
     * �����ǵ���action��Ȼ��Ҫ��Interceptor֮ǰ���õ����ݶ�д�ڵ���invoke֮ǰ��Ҫ��Interceptor֮����õ����ݶ�д�ڵ���invoke����֮��  
     */    
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,  
                           ModelAndView modelAndView) throws Exception { 
    	logger.info("com.study.springboot.interceptor.ErrorInterceptor.postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)");
    	if(response.getStatus()==500){  
            modelAndView.setViewName("/error/500");  
        }else if(response.getStatus()==404){  
            modelAndView.setViewName("/error/404");  
            modelAndView.addObject("name", "404����");
        }  
    }  
  
    /**  
     * �÷���Ҳ����Ҫ��ǰ��Ӧ��Interceptor��preHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С��÷������������������֮��Ҳ����DispatcherServlet��Ⱦ����ͼִ�У�  
     * �����������Ҫ����������������Դ�ģ���Ȼ�������Ҳֻ���ڵ�ǰ���Interceptor��preHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С�  
     */    
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  
            throws Exception {  
    	logger.info("com.study.springboot.interceptor.ErrorInterceptor.afterCompletion(HttpServletRequest, HttpServletResponse, Object, Exception)");
    }  
}
