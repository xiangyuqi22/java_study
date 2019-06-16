package structure.pattern.facade.main;

import structure.pattern.facade.Circle;
import structure.pattern.facade.Rectangle;
import structure.pattern.facade.ShapeMaker;
import structure.pattern.facade.Square;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月1日
 * @author xiangning
 * @since JDK1.8
 */
public class FacadeMain {
	
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker(new Circle(), new Rectangle(), new Square());
		
		shapeMaker.drawCircle();
		System.out.println("-----------------------");
		shapeMaker.drawRectangle();
		System.out.println("-----------------------");
		shapeMaker.drawRectangle();
		System.out.println("-----------------------");
		
		ShapeMaker shapeMaker2 = new ShapeMaker();
		shapeMaker2.addSet(new Circle());
		shapeMaker2.addSet(new Rectangle());
		shapeMaker2.draw();
	}

}
