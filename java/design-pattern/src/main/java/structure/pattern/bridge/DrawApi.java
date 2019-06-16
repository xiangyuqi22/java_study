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
public interface DrawApi {
	
	/**
	 * DrawCircle:(����һ��������ɫ��Բ��)
	 * @author xiangning
	 *
	 * @param x
	 * @param y
	 * @param radius
	 */
	public void DrawCircle(int x , int y , int radius);
	
	/**
	 * DrawSquare:(����һ��������ɫ�ķ���)
	 * @author xiangning
	 *
	 * @param x
	 * @param y
	 */
	public void DrawSquare(int x , int y );
	

}
