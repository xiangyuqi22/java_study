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
public class Circle extends Shape {
	
	public Circle() {
		this.type = "circle";
		System.out.println("circle -> ���췽��");
	}

	@Override
	public void draw() {
		System.out.println("create.pattern.prototypepattern.Circle.draw()  -> "  + type 
				+ ";id = " + id);
		System.out.println(size);
	}

}
