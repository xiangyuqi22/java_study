package structure.pattern.facade;

import java.util.HashSet;
import java.util.Set;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��1��
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
