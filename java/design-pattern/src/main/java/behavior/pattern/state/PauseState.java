package behavior.pattern.state;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月9日
 * @author xiangning
 * @since JDK1.8
 */
public class PauseState implements State {

	@Override
	public void doAction(Context context) {
		context.setState(this);
	}
	
	public String toString() {
		return "暂停状态";
	}

}
