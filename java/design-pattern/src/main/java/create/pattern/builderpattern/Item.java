package create.pattern.builderpattern;
/**
 * <PRE>
 * ����������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��23��
 * @author xiangning
 * @since JDK1.8
 */
public interface Item {
	
//	public Packing setPack(Packing pack);
	
	public String name();
	
	public Packing packing();
	
	public float price();

}