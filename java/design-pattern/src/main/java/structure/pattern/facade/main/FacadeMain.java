package structure.pattern.facade.main;

import structure.pattern.facade.Circle;
import structure.pattern.facade.Rectangle;
import structure.pattern.facade.ShapeMaker;
import structure.pattern.facade.Square;

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
