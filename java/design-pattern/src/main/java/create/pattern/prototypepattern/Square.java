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
public class Square extends Shape {
	
	public Square() {
		this.type = "Square";
		System.out.println("square -> ���췽��");
	}

	@Override
	public void draw() {
		System.out.println("create.pattern.prototypepattern.Square.draw() -> " + type 
					+ ";id = " + id);
		
		System.out.println(size);
		
		
	}

}
