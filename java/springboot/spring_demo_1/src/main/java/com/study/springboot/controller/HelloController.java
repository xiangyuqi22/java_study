package com.study.springboot.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.interceptor.ErrorInterceptor;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：spring_demo_1</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月5日
 * @author xiangning
 * @since JDK1.8
 */
@Controller
public class HelloController {

	 private static final Logger logger = Logger.getLogger(HelloController.class);

	@RequestMapping("/hello")
    public String greeting(ModelMap map) {
		logger.info("com.study.springboot.controller.HelloController.greeting(ModelMap)");
        map.addAttribute("name", "模板引擎");
        map.addAttribute("host", "测试成功");
        return "hello";
    }

}
