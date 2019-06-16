package structure.pattern.facade;

import java.util.HashSet;
import java.util.Set;

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

public class ShapeMaker {
	
	private Shape circle;
	private Shape rectangle;
	private Shape square;
	
	private Set<Shape> shapeSet;
	
	public ShapeMaker() {
		shapeSet = new HashSet<>();
	}
	
	
	public ShapeMaker(Circle circle, Rectangle rectangle, Square square) {
		super();
		this.circle = circle;
		this.rectangle = rectangle;
		this.square = square;
	}
	
	public void drawCircle() {
		circle.draw();
	}
	
	public void drawRectangle() {
		rectangle.draw();
	}
	
	public void drawSquare() {
		square.draw();
	}
	
	public void addSet(Shape shape) {
		shapeSet.add(shape);
	}
	
	public void removeSet(Shape shape) {
		shapeSet.remove(shape);
	}
	
	public void draw() {
		for (Shape shape : shapeSet) {
			shape.draw();
		}
	}
	
	

}
