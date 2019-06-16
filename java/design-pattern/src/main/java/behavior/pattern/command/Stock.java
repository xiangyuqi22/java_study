package behavior.pattern.command;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��6��
 * @author xiangning
 * @since JDK1.8
 */
public class Stock {
	
	private String name = "book";
	
	private float price = 100.00F;
	
	public void buy() {
		System.out.println("�����ˣ�" + name + "���۸��ǣ�" + price);
	}
	
	public void sell() {
		System.out.println("�����ˣ�" + name + "���۸��ǣ�" + price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	

}
