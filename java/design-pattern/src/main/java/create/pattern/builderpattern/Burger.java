package create.pattern.builderpattern;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��23��
 * @author xiangning
 * @since JDK1.8
 */
public abstract class Burger implements Item{
	
	/**
	 * ʹ��wrapper��װ
	 */
	public Packing packing() {
		return new Wrapper();
	}
	
	
	
}
