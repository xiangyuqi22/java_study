package com.example.bean;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Data
@Getter
@Setter
@ToString
public class User2 {
	
	private Integer id;
	
	private String name;
	
	private String phone;
	
	private Date CreateTime;
	
	private int age;

}
