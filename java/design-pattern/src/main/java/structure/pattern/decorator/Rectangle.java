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
public class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("画一个正方形");
	}

}
