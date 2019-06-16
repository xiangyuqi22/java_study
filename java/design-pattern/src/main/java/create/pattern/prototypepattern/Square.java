package create.pattern.prototypepattern;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月24日
 * @author xiangning
 * @since JDK1.8
 */
public class Square extends Shape {
	
	public Square() {
		this.type = "Square";
		System.out.println("square -> 构造方法");
	}

	@Override
	public void draw() {
		System.out.println("create.pattern.prototypepattern.Square.draw() -> " + type 
					+ ";id = " + id);
		
		System.out.println(size);
		
		
	}

}
