package behavior.pattern.command;

import java.util.ArrayList;
import java.util.List;

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
public class StockOrders {
	
	private List<Order> list = new ArrayList<>();
	
	public void addOrder(Order order) {
//		order.execute();
		list.add(order);
	}
	
	public void executeAll() {
		for (Order order : list) {
			order.execute();
		}
		list.clear();
		
	}
	
	

}
