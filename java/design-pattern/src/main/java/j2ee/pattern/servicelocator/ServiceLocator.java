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
public class ServiceLocator {
	
	private static Cache cache;
	
	static {
		cache = new Cache();
	}
	
	public static Service getService(String serviceName) {
		Service service = cache.getService(serviceName);
		if(service == null) {
			InitialContext initialContext = new InitialContext();
			service = initialContext.lookUp(serviceName);
			cache.addService(service);
		}
		return service;
	}
	
	
	
	
}
