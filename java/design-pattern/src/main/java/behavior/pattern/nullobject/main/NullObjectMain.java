package behavior.pattern.nullobject.main;

import behavior.pattern.nullobject.CustomerFactory;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��9��
 * @author xiangning
 * @since JDK1.8
 */
public class NullObjectMain {
	
	public static void main(String[] args) {
		
		System.out.println(CustomerFactory.getCustomer("�ν�").getName());
		
		System.out.println(CustomerFactory.getCustomer("�Ÿ�").getName());
		
		System.out.println(CustomerFactory.getCustomer("����").getName());
		
	}

}
