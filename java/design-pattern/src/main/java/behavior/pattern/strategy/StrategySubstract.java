package behavior.pattern.strategy;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月10日
 * @author xiangning
 * @since JDK1.8
 */
public class StrategySubstract implements Strategy {

	@Override
	public void doOperation(int a, int b) {
		System.out.println(" a - b = " + (a - b));
	}

}
