package structure.pattern.flyweight;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��2��
 * @author xiangning
 * @since JDK1.8
 */
public class Rectangle extends Shape {

	public Rectangle(int x, int y, int radius, String color) {
		super(x, y, radius, color);
	}

	@Override
	public void draw() {
		System.out.println("����һ��" + type + ";��ɫ��" + color + ";x = " + x + ";y = " + y + ";radius = " + radius);
	}

	@Override
	protected void setType() {
		this.type = "������";
	}

}
