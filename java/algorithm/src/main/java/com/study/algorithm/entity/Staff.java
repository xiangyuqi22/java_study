package com.study.algorithm.entity;
/**
 * <PRE>
 * 功能描述：员工实体类
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 
 * @version 1.0 2020年2月14日
 * @author xiangning
 * @since JDK1.8
 */
public class Staff {
	
	private long id;
	
	private String name;
	
	private String sex;
	
	private int age;
	
	

	public Staff(long id, String name, String sex, int age) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}



	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	

}
