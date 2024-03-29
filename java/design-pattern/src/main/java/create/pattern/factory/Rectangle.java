package create.pattern.factory;
/**
 * <PRE>
 * 画一个长方型
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月16日
 * @author xiangning
 * @since JDK1.8
 */
public class Rectangle implements IShape {

	public void draw() {
		System.out.println("create.pattern.factory.Rectangle.draw()  -> 长方形");
	}

}
