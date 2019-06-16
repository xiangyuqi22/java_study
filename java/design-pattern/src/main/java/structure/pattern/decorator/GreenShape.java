package structure.pattern.decorator;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月30日
 * @author xiangning
 * @since JDK1.8
 */
public class GreenShape extends AbstractShape {

	public GreenShape(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		shape.draw();
		System.out.println("添加一个绿色的边框");
	}

}
