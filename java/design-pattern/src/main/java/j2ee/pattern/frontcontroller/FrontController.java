package j2ee.pattern.frontcontroller;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��16��
 * @author xiangning
 * @since JDK1.8
 */
public class FrontController {
	
	private Dispatcher dispatcher;
	
	public FrontController() {
		dispatcher = new Dispatcher();
	}
	
	private boolean isAuthenticUser(String request) {
		return true;
	}
	
	private void trackRequest(String request) {
		System.out.println("׷��" + request);
	}
	
	public void dispatchRequest(String request) {
		this.trackRequest(request);
		if(isAuthenticUser(request)) {
			dispatcher.dispatcher(request);
		}
	}
	

}
