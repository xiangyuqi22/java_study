package other.basic.java.bean;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��23��
 * @author xiangning
 * @since JDK1.8
 */
public class Fish {
	
	private String type;
	
	private String name;
	
	private Integer age;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	
	public static Fish getFish() {
		Fish fish = new Fish();
		fish.type = "����";
		fish.name = "С��";
		fish.age = 7;
		return fish;
	}

	@Override
	public String toString() {
		return "Fish [type=" + type + ", name=" + name + ", age=" + age + "]";
	}
	
	

}
