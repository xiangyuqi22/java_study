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
public class Square extends Shape{

	public Square(int x , int y ,DrawApi drawApi) {
		super(drawApi,x,y);
	}

	@Override
	public void draw() {
		drawApi.DrawSquare(x, y);
	}

}
