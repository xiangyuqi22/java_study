package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.annotation.MySpringbootAnnotation;

@MySpringbootAnnotation
@ComponentScan("com.example.controller,com.example.config")
@Controller
@ServletComponentScan("com.example.common")
public class SpringbootDemo3Application {
	
	@RequestMapping("/")
	@ResponseBody
	public String greeting() {
		return "hello world ! springboot_demo_3";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo3Application.class, args);
	}

}
