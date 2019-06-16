package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月11日
 * @author xiangning
 * @since JDK1.8
 */
@RestController
@RequestMapping("/other")
public class OtherRequestController {
	
	Map<String,Object> param = new HashMap<>();
	
	@PostMapping("/post")
	public Object post(String name,int id) {
		param.clear();
		param.put("name", name);
		param.put("id", id);
		param.put("result", "提交成功");
		return param;
	}
	
	
	@PutMapping("/put")
	public Object put(String name,int id) {
		param.clear();
		param.put("name", name);
		param.put("id", id);
		param.put("result", "修改成功");
		return param;
	}
	
	@DeleteMapping("/delete")
	public Object delete(String name,int id) {
		param.clear();
		param.put("name", name);
		param.put("id", id);
		param.put("result", "删除成功");
		return param;
	}
	
}
