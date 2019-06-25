package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.example.bean.User2;

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
public interface UserMapper {
	
	@Insert("INSERT INTO user(name,phone,age,create_time) VALUES(#{name},#{phone},#{age},#{createTime})")
	@Options(useCache = false,useGeneratedKeys = true,keyProperty="id",keyColumn = "id")
	Integer insert(User2 user);

}
