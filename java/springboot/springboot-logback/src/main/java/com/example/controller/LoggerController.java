package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot-logback</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年8月14日
 * @author xiangning
 * @since JDK1.8
 */
@RestController
public class LoggerController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/logger")
	public String testLogger() {
		log.debug("debug - level");
		log.info("info - level");
		log.warn("warn - level");
		log.error("error - level");
		return "测试日志";
		
	}

}
