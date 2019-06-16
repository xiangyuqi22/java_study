package j2ee.pattern.interceptingfilter;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��17��
 * @author xiangning
 * @since JDK1.8
 */
public class Client {
	
	private FilterManager filterManager;
	
	public Client(Target target) {
		this.filterManager = new FilterManager(target);
		this.filterManager.setFilter(new AuthenticationFilter());
		this.filterManager.setFilter(new DebugFilter());
	}
	
	public void sendRequest(String request) {
		this.filterManager.filterRequest(request);
	}
	
}
