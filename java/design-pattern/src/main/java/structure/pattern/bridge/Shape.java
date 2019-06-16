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
public abstract class Shape {
	
	protected int x , y , radius;
	
	protected  DrawApi drawApi;
	
	public Shape(DrawApi drawApi , int x , int y ) {
		this.drawApi = drawApi;
		this.x = x;
		this.y = y;
	}
	
	public abstract void draw();

}
