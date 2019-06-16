package behavior.pattern.strategy;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��10��
 * @author xiangning
 * @since JDK1.8
 */
public class Context {
	
	private Strategy strategy;
	
	public void setStrategy( Strategy strategy ) {
		this.strategy = strategy;
	}
	
	public void doOperation( int a , int b ) {
		this.strategy.doOperation(a, b);
	}
	

}
