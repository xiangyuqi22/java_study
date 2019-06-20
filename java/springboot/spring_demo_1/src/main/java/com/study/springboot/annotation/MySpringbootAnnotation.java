package com.study.springboot.annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.AliasFor;


@SpringBootApplication
public @interface MySpringbootAnnotation {
	
	@AliasFor(annotation = SpringBootApplication.class, attribute = "basePackages")
	String[] scanBasePackages() default {};
	
}
