package com.example.controller;

import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;
import com.example.utils.JsonUtils;
import com.example.utils.RedisUtils;

import net.minidev.json.JSONUtil;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月20日
 * @author xiangning
 * @since JDK1.8
 */
@RestController()
@RequestMapping("/redis")
public class RedisController {
	
	
	@Autowired
	private RedisUtils redis;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@RequestMapping("/add")
	public Object add(@RequestParam(defaultValue = "springboot") String data) {
		
		stringRedisTemplate.opsForValue().set("name", data);
		
		return data;
	}
	
	
	@RequestMapping("/get")
	public Object get() {
		return stringRedisTemplate.opsForValue().get("name");
	}
	
	@RequestMapping("/redis_util/add")
	public Object addDataUseUtil(String data) {
		redis.set("data", data);
		return data;
	}
	
	@RequestMapping("/redis_util/get")
	public Object getDataUseUtil() {
		return redis.get("data");
	}
	
	/**
	 * 以":"隔开的话,在redis存储的时候 ,会进行分组.管理就更加方便 ,所以key命名要遵循这个规则
	 */
	private static final String KEY_PREFIX = "basic:user:";
	@RequestMapping("/redis_util/add_user")
	public Object addUserUseUtil(String data ,@RequestParam
			(defaultValue="1000" ,  name="user_id")Long userId) {
		User user = new User();
		user.setAge(19);
		user.setCreateTime(new Date());
		user.setGender("男");
		user.setId(userId);
		user.setName("李白");
		user.setPwd("1234567889");
		redis.set(KEY_PREFIX + user.getId(), JsonUtils.obj2String(user));
		return user;
	}
	
	@RequestMapping("/redis_util/get_user")
	public Object getUserUseUtil(@RequestParam
			(defaultValue="1000" ,  name="user_id")Long userId) {
		Object object = redis.get(KEY_PREFIX + userId);
		if(object == null) {
			return null;
		}
		return JsonUtils.string2Obj(object.toString(), User.class);
	}

}
