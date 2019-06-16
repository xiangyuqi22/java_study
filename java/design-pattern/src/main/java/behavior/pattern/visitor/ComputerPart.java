package behavior.pattern.visitor;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��11��
 * @author xiangning
 * @since JDK1.8
 */
public abstract class ComputerPart {
	
	public abstract void accept(ComputerPartVisitor computrerPartVisitor);
	
	public abstract void say();

}
