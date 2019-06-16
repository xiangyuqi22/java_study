package other.basic.java.bean;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月23日
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
		fish.type = "鲤鱼";
		fish.name = "小鲤";
		fish.age = 7;
		return fish;
	}

	@Override
	public String toString() {
		return "Fish [type=" + type + ", name=" + name + ", age=" + age + "]";
	}
	
	

}
