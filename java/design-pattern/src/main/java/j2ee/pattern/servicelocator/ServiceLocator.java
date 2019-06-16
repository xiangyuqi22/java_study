package j2ee.pattern.servicelocator;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月18日
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
