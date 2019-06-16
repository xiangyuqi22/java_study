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
public class RealCustomer extends AbstractCustomer {

	public RealCustomer(String name) {
		super(name);
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
