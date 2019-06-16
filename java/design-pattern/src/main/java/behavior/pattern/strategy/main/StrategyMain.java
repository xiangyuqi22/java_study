package behavior.pattern.strategy.main;

import behavior.pattern.strategy.Context;
import behavior.pattern.strategy.StrategyAdd;
import behavior.pattern.strategy.StrategyMultiply;
import behavior.pattern.strategy.StrategySubstract;

/**
 * <PRE>
	
	����ģʽ
		�ڲ���ģʽ��Strategy Pattern���У�һ�������Ϊ�����㷨����������ʱ���ġ��������͵����ģʽ������Ϊ��ģʽ��
		�ڲ���ģʽ�У����Ǵ�����ʾ���ֲ��ԵĶ����һ����Ϊ���Ų��Զ���ı���ı�� context ����
		���Զ���ı� context �����ִ���㷨��

	��ͼ��
		����һϵ�е��㷨,������һ������װ����, ����ʹ���ǿ��໥�滻��
	��Ҫ�����
		���ж����㷨���Ƶ�����£�ʹ�� if...else �������ĸ��Ӻ�����ά����
	��ʱʹ�ã�
		һ��ϵͳ���������࣬���������ǵ�ֻ������ֱ�ӵ���Ϊ��
	��ν����
		����Щ�㷨��װ��һ��һ�����࣬������滻��
	�ؼ����룺
		ʵ��ͬһ���ӿڡ�
	Ӧ��ʵ���� 
		1��������Ľ�����ƣ�ÿһ�����Ҿ���һ�����ԡ� 
		2�����еĳ��η�ʽ��ѡ�������г�����������ÿһ�����з�ʽ����һ�����ԡ� 
		3��JAVA AWT �е� LayoutManager��
	�ŵ㣺 
		1���㷨���������л��� 
		2������ʹ�ö��������жϡ� 
		3����չ�����á�
	ȱ�㣺 
		1������������ࡣ 
		2�����в����඼��Ҫ���Ⱪ¶��
	ʹ�ó����� 
		1�������һ��ϵͳ����������࣬����֮���������������ǵ���Ϊ����ôʹ�ò���ģʽ���Զ�̬����һ�������������Ϊ��ѡ��һ����Ϊ�� 
		2��һ��ϵͳ��Ҫ��̬���ڼ����㷨��ѡ��һ�֡� 
		3�����һ�������кܶ����Ϊ���������ǡ����ģʽ����Щ��Ϊ��ֻ��ʹ�ö��ص�����ѡ�������ʵ�֡�
	ע�����
		���һ��ϵͳ�Ĳ��Զ����ĸ�������Ҫ����ʹ�û��ģʽ��������������͵����⡣
	

 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��10��
 * @author xiangning
 * @since JDK1.8
 */
public class StrategyMain {
	
	public static void main(String[] args) {
		Context context = new Context();
		context.setStrategy(new StrategyAdd());
		context.doOperation(10, 20);
		context.setStrategy(new StrategySubstract());
		context.doOperation(10, 20);
		context.setStrategy(new StrategyMultiply());
		context.doOperation(10, 20);
		
	}

}
