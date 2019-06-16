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
public class Square extends Shape{

	public Square(int x , int y ,DrawApi drawApi) {
		super(drawApi,x,y);
	}

	@Override
	public void draw() {
		drawApi.DrawSquare(x, y);
	}

}
