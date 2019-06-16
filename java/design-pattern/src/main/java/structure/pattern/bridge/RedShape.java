package structure.pattern.bridge;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月26日
 * @author xiangning
 * @since JDK1.8
 */
public class RedShape implements DrawApi {

	@Override
	public void DrawCircle(int x, int y, int radius) {
		System.out.println("structure.pattern.bridge.RedCircle.DrawCircle(x = " + x + ";y = " + y + ";radius = " + radius + ")");
	}

	@Override
	public void DrawSquare(int x, int y) {
		System.out.println("structure.pattern.bridge.RedShape.DrawSquare(x = " + x + ";y = " + y + ")");
	}

}
