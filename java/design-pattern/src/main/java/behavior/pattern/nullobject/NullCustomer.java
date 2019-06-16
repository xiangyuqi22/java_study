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
public class NullCustomer extends AbstractCustomer {

	public NullCustomer() {
		super("");
	}

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public String getName() {
		return "û����ɽ�ú�������";
	}

}
