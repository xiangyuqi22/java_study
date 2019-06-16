package j2ee.pattern.interceptingfilter;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月17日
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
