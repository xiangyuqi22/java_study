package behavior.pattern.mediator;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��7��
 * @author xiangning
 * @since JDK1.8
 */
public class User {
	private String name;
	
	public User(String name ) {
		this.name  = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void sendMessage(String message) {
		ChatRoom.showMessage(this, message);;
	}

}
