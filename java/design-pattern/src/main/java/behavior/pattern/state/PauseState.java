package behavior.pattern.state;
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
public class PauseState implements State {

	@Override
	public void doAction(Context context) {
		context.setState(this);
	}
	
	public String toString() {
		return "��ͣ״̬";
	}

}
