package j2ee.pattern.servicelocator;

import java.util.ArrayList;
import java.util.List;

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
public class Cache {
	
	private List<Service> services = new ArrayList<>();
	
	public void addService(Service service) {
		services.add(service);
	}
	
	public Service getService(String serviceName) {
		for (Service service : services) {
			if(service.getName().equals(serviceName)) {
				return service;
			}
		}
		return null;
	}
	

}
