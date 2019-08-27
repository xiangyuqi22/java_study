package com.study.springboot.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class User {
	
	private Long id;
	
	@JsonInclude(Include.NON_EMPTY)
	private String name;
	
	@JsonInclude(Include.NON_NULL)
	private Integer age;
	
	@JsonProperty("sex")
	private String gender;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss" , locale = "zh" , timezone = "GMT+8")
	private Date createTime;
	
	
	
	@JsonIgnore
	private String pwd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
