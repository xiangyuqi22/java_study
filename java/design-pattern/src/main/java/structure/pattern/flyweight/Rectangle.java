package structure.pattern.flyweight;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月2日
 * @author xiangning
 * @since JDK1.8
 */
public class Rectangle extends Shape {

	public Rectangle(int x, int y, int radius, String color) {
		super(x, y, radius, color);
	}

	@Override
	public void draw() {
		System.out.println("画出一个" + type + ";颜色是" + color + ";x = " + x + ";y = " + y + ";radius = " + radius);
	}

	@Override
	protected void setType() {
		this.type = "长方形";
	}

}
