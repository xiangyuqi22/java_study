package behavior.pattern.template;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��10��
 * @author xiangning
 * @since JDK1.8
 */
public class PhoneGame extends Game {

	@Override
	protected void initialize() {
		System.out.println("��ʼ�� �ֻ� ��Ϸ");
	}

	@Override
	protected void startPlay() {
		System.out.println("��ʼ �ֻ� ��Ϸ");

	}

	@Override
	protected void stopPlay() {
		System.out.println("ֹͣ �ֻ� ��Ϸ");
	}

}
