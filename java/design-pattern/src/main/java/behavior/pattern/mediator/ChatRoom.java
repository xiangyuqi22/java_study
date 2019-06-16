package behavior.pattern.mediator;

import java.util.Date;

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
public class ChatRoom {
	
	public static void showMessage( User user , String message ) {
		System.out.println(new Date().toString() + " -> [" + user.getName() + "] : " + message);
	}

}
