package structure.pattern.decorator;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��30��
 * @author xiangning
 * @since JDK1.8
 */
public class GreenShape extends AbstractShape {

	public GreenShape(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		shape.draw();
		System.out.println("���һ����ɫ�ı߿�");
	}

}
