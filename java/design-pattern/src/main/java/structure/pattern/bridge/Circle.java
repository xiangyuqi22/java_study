package structure.pattern.bridge;


/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��26��
 * @author xiangning
 * @since JDK1.8
 */
public class Circle extends Shape {
	
	public Circle(int x , int y , int radius , DrawApi drawApi) {
		super(drawApi,x,y);
		this.radius = radius;
		
	}

	@Override
	public void draw() {
		drawApi.DrawCircle(x, y, radius);
	}

}
