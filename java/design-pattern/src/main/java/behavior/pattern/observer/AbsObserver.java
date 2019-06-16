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
public abstract class AbsObserver {
	
	protected Subject subject;
	
	public AbsObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	
	public abstract void update();

}
