package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication()
@ComponentScan(value = {"com.example"})
@Controller
public class SpringbootApplication {
	
	
	@RequestMapping("/")
	@ResponseBody
	public String greeting() {
		return "hello world ! logback";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
