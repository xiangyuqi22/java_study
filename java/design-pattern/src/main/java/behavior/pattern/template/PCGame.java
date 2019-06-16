package behavior.pattern.template;
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
public class PCGame extends Game {

	@Override
	protected void initialize() {
		System.out.println("初始化 PC 游戏");
	}

	@Override
	protected void startPlay() {
		System.out.println("开始 PC 游戏");
	}

	@Override
	protected void stopPlay() {
		System.out.println("停止 PC 游戏");
	}

}
