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
public class SellStock implements Order {

	private Stock stock;
	
	public SellStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void execute() {
		stock.sell();
	}
	
	
	

}
