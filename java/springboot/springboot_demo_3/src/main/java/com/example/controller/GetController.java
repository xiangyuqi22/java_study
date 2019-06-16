package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;
import com.example.config.ServletSettings;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月10日
 * @author xiangning
 * @since JDK1.8
 */
@RestController
@RequestMapping("/get")
public class GetController {
	
	@Autowired
	private ServletSettings servletSettings;
	
	Map<String,String> param = new HashMap<>();
	
	/**
	 * getUser1:(使用get请求从路径中获取值)
	 * @author xiangning
	 *
	 * @param cityId
	 * @param userId
	 * @return
	 */
	@RequestMapping(path="/get1/{city_id}/{user_id}" , method = RequestMethod.GET)
	public Object getUser1(@PathVariable("city_id") String cityId,@PathVariable("user_id") String userId) {
		param.clear();
		param.put("cityId", cityId);
		param.put("userId", userId);
		return param;
	}
	
	/**
	 * getUser2:(使用@GetMapping，一个顶两)
	 * @author xiangning
	 *
	 * @param cityId
	 * @param userId
	 * @return
	 */
	@GetMapping(value = "/get2/{city_id}/{user_id}")
	public Object getUser2(@PathVariable("city_id") String cityId,@PathVariable("user_id") String userId) {
		param.clear();
		param.put("cityId", cityId);
		param.put("userId", userId);
		return param;
	}
	
	
	/**
	 * getUser3:(必填参数1：从路径中获取必填参数，但是这个没什么用，因为如果没有该参数的话，路径请求就不正确，会变为404)
	 * @author xiangning
	 *
	 * @param cityId
	 * @param userId
	 * @return
	 */
	@GetMapping(value = "/get3/{city_id}/{user_id}")
	public Object getUser3(@PathVariable("city_id") @RequestParam(required = true,defaultValue = "99" ) String cityId,@PathVariable("user_id") String userId) {
		param.clear();
		param.put("cityId", cityId);
		param.put("userId", userId);
		return param;
	}
	
	/**
	 * getUser4:(默认值和必填参数)
	 * @author xiangning
	 *
	 * @param cityId
	 * @param userId
	 * @return
	 */
	@GetMapping(value = "/get4")
	public Object getUser4( @RequestParam(required = true,defaultValue = "99",name = "city_id" ) String cityId,
			@RequestParam(required = true,defaultValue = "111",name = "user_id" )  String userId) {
		param.clear();
		param.put("cityId", cityId);
		param.put("userId", userId);
		return param;
	}
	
	/**
	 * getUser5:(bean对象传参
	 * 			注意：需要指定http头为：content-type:application/json
	 * 				使用body传输数据
	 * 
	 * )
	 * @author xiangning
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/get5")
	public Object getUser5(@RequestBody User user) {
		return user;
	}
	
	/**
	 * getHeader:(获取请求头信息)
	 * @author xiangning
	 *
	 * @param tocken
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/get6")
	public Object getHeader(@RequestHeader("tocken") String tocken , String id) {
		param.clear();
		param.put("tocken", tocken);
		param.put("id", id);
		return param;
	}
	
	@GetMapping(value = "/get7")
	public Object getRequest(HttpServletRequest httpServletRequest) {
		param.clear();
		param.put("tocken", httpServletRequest.getParameter("tocken"));
		param.put("id",  httpServletRequest.getParameter("id"));
		return param;
	}
	
	
	
	@GetMapping(value = "/servlet")
	public Object getServletSetting(HttpServletRequest httpServletRequest) {

		return servletSettings;
	}
	
	
	

}
