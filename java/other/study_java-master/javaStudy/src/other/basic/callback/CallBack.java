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
public class CallBack{
	public void doing(ICallback deal) {
		System.out.println("������˭�������������Ҷ�����������д�����������֮�� �ٷ��ػ�ȥ���");
		deal.doingOver(deal);
	}
}
