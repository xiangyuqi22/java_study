package behavior.pattern.nullobject;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��9��
 * @author xiangning
 * @since JDK1.8
 */
public abstract class AbstractCustomer {
	
	protected String name;
	
	public AbstractCustomer(String name) {
		this.name = name;
	}
	
	
	public abstract boolean isNull();
	
	public abstract String getName();

}
