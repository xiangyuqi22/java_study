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
public class StrategyMultiply implements Strategy {

	@Override
	public void doOperation(int a, int b) {
		System.out.println(" a x b = " + (a * b));

	}

}
