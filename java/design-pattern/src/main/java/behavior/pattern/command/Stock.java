package behavior.pattern.command;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月6日
 * @author xiangning
 * @since JDK1.8
 */
public class Stock {
	
	private String name = "book";
	
	private float price = 100.00F;
	
	public void buy() {
		System.out.println("购买了：" + name + "；价格是：" + price);
	}
	
	public void sell() {
		System.out.println("卖出了：" + name + "；价格是：" + price);
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
