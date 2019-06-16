package behavior.pattern.command;

import java.util.ArrayList;
import java.util.List;

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
