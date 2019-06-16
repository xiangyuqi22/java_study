package j2ee.pattern.businessdelegate;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��13��
 * @author xiangning
 * @since JDK1.8
 */
public class BusinessLookup {
	
	public BusinessService lookup(String type) {
		if(type.startsWith("EJB")) {
			return new EJBService();
		}else {
			return new JMService();
		}
	}

}
