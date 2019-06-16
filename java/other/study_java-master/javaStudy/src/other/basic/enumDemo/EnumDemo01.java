package other.basic.enumDemo;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年2月25日
 * @author xiangning
 * @since JDK1.8
 */
public class EnumDemo01 {
	
	public static void main(String[] args) {
		System.out.println(EnumDemo.MONDAY.getName());
	}
}


enum EnumDemo {
	MONDAY(1,"星期一"),FRIDAY(2,"星期二");
	
	
	static {
		MONDAY.setName("这是星期一");
		EnumDemo[] values = EnumDemo.values();
		System.out.println(values);
		for (EnumDemo enumDemo : values) {
			System.out.println(enumDemo.name());
			if(enumDemo.name().equals("MONDAY")) {
				enumDemo.setName("这才是星期一");
			}
		}
		
	}
	
	private int num;
	
	private String name;
	
	EnumDemo(int num,String name){
		this.num = num;
		this.name= name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}