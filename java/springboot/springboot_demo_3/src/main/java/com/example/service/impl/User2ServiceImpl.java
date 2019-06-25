package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.bean.User;
import com.example.bean.User2;
import com.example.mapper.UserMapper;
import com.example.service.User2Service;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月25日
 * @author xiangning
 * @since JDK1.8
 */
@Service
public class User2ServiceImpl implements User2Service {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public Integer insert(@RequestBody User2 user) {
		return userMapper.insert(user);
	}

}
