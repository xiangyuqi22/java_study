package beanUtils.bean;

import java.util.List;



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
public class Persion {
	private String name;
	private String nickName;
	private int age;
	private List<String> list1;
	
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
	public List<String> getList1() {
		return list1;
	}
	public void setList1(List<String> list1) {
		this.list1 = list1;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public List<String> getList() {
		return list1;
	}
	public void setList(List<String> list1) {
		this.list1 = list1;
	}
	@Override
	public String toString() {
		return "Persion [name=" + name + ", age=" + age + ", list1=" + list1 + "]";
	}

	
	
	
}
