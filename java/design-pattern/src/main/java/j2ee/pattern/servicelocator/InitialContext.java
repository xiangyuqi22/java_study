package j2ee.pattern.servicelocator;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��18��
 * @author xiangning
 * @since JDK1.8
 */
public class InitialContext {
	
	public  Service lookUp(String serviceName) {
		if("service1".equalsIgnoreCase(serviceName)) {
			return new Service1();
		}else if ("service2".equalsIgnoreCase(serviceName)) {
			return new Service2();
		}
		return null;
	}

}
