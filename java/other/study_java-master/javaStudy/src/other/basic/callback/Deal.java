package other.basic.callback;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��9��
 * @author xiangning
 * @since JDK1.8
 */
public class Deal implements ICallback{

	public void doing() {
		System.out.println("��ʼ��������");
		new CallBack().doing(this);
		System.out.println("����������� ");
	}
	

	@Override
	public void doingOver(ICallback deal) {
		System.out.println("���������");
		
	}
}
