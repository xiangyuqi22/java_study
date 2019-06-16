package j2ee.pattern.businessdelegate;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月13日
 * @author xiangning
 * @since JDK1.8
 */
public class JMService implements BusinessService {

	@Override
	public void doProcessing() {
		System.out.println("j2ee.pattern.businessdelegate.JMService");
	}

	@Override
	public void doSomething() {
		BusinessService.super.doSomething();
		System.out.println("j2ee.pattern.businessdelegate.JMService.doSomething()");
	}

}
