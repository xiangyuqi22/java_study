package behavior.pattern.command2;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��6��
 * @author xiangning
 * @since JDK1.8
 */
public class Delete extends AbstractOrder {

	@Override
	public void execute() {
		System.out.println("ִ��һ��ɾ������");
	}

	@Override
	public void cancle() {
		System.out.println("����һ��ɾ������");
	}

}
