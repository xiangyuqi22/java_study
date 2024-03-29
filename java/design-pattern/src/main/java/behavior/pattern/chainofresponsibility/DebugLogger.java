package behavior.pattern.chainofresponsibility;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月6日
 * @author xiangning
 * @since JDK1.8
 */
public class DebugLogger extends AbstractLogger {

	public DebugLogger(AbstractLogger nextAbstractLogger, int level) {
		super(nextAbstractLogger, level);
	}

	@Override
	protected void write(String message) {
		System.out.println("structure.pattern.chainofresponsibility.DebugLogger" + message);
	}

}
