package create.pattern.prototypepattern;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��24��
 * @author xiangning
 * @since JDK1.8
 */
public class Rectangle extends Shape {
	
	public Rectangle() {
		this.type = "rectangle";
		System.out.println("Rectangle -> ���췽��");
	}

	@Override
	public void draw() {
		System.out.println("create.pattern.prototypepattern.Rectangle.draw() -> "  + type 
				+ ";id = " + id);
		System.out.println(size);
	}

}
