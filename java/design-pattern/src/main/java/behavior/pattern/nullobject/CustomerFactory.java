package behavior.pattern.nullobject;
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
public class CustomerFactory {
	
	private static final String[] names = new String[] {"�ν�","¬����","����","ʯ��"};
	
	
	public static AbstractCustomer getCustomer(String name) {
		
		for (String str : names) {
			if(str.equalsIgnoreCase(name)) {
				return new RealCustomer(str);
			}
		}
		
		return new NullCustomer();
	}

}
