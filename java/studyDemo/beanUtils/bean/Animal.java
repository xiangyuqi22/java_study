package beanUtils.bean;

import java.util.List;

import beanUtils.annotation.BeanTrans;


/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：demo</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月2日
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
