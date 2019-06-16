package beanUtils.bean;

import java.util.List;

import beanUtils.annotation.BeanTrans;


/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�demo</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��2��
 * @author xiangning
 * @since JDK1.8
 */
public class Animal {
	private String name;
	private int age;
	@BeanTrans("list1")
	private List<String> list2;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getList2() {
		return list2;
	}
	public void setList2(List<String> list2) {
		this.list2 = list2;
	}
	
	public void setList(List<String> list2) {
		this.list2 = list2;
	}
	
	public List<String> getList() {
		return list2;
	}
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", list2=" + list2 + "]";
	}
	
	
	
}
