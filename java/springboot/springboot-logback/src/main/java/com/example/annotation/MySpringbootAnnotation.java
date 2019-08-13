package com.example.annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.AliasFor;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月9日
 * @author xiangning
 * @since JDK1.8
 */
@SpringBootApplication()
public @interface MySpringbootAnnotation {
	
	@AliasFor(annotation = SpringBootApplication.class, attribute = "basePackages")
	String[] scanBasePackages() default {};
	
}
