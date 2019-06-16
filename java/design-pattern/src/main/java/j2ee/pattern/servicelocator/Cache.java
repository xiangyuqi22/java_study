package j2ee.pattern.servicelocator;

import java.util.ArrayList;
import java.util.List;

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
