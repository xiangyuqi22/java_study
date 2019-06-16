package behavior.pattern.observer;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月8日
 * @author xiangning
 * @since JDK1.8
 */
public class OctalObserver extends AbsObserver {

	public OctalObserver(Subject subject) {
		super(subject);
	}

	@Override
	public void update() {
		System.out.println("更新了 -> behavior.pattern.observer.OctalObserver   -->   "
				+ Integer.toOctalString( subject.getStatus() ) 
				);
	}

}
