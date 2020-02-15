package com.study.algorithm.entity;
/**
 * <PRE>
 * ����������Ա��ʵ����
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * 
 * @version 1.0 2020��2��14��
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
