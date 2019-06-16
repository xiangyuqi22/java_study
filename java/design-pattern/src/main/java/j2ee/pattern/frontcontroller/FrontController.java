package j2ee.pattern.frontcontroller;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月16日
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
		System.out.println("追踪" + request);
	}
	
	public void dispatchRequest(String request) {
		this.trackRequest(request);
		if(isAuthenticUser(request)) {
			dispatcher.dispatcher(request);
		}
	}
	

}
