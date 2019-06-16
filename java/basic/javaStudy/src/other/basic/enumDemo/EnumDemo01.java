package other.basic.enumDemo;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��2��25��
 * @author xiangning
 * @since JDK1.8
 */
public class EnumDemo01 {
	
	public static void main(String[] args) {
		System.out.println(EnumDemo.MONDAY.getName());
	}
}


enum EnumDemo {
	MONDAY(1,"����һ"),FRIDAY(2,"���ڶ�");
	
	
	static {
		MONDAY.setName("��������һ");
		EnumDemo[] values = EnumDemo.values();
		System.out.println(values);
		for (EnumDemo enumDemo : values) {
			System.out.println(enumDemo.name());
			if(enumDemo.name().equals("MONDAY")) {
				enumDemo.setName("���������һ");
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