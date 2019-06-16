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
public class RedShape implements DrawApi {

	@Override
	public void DrawCircle(int x, int y, int radius) {
		System.out.println("structure.pattern.bridge.RedCircle.DrawCircle(x = " + x + ";y = " + y + ";radius = " + radius + ")");
	}

	@Override
	public void DrawSquare(int x, int y) {
		System.out.println("structure.pattern.bridge.RedShape.DrawSquare(x = " + x + ";y = " + y + ")");
	}

}
