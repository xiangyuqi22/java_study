package behavior.pattern.mediator;

import java.util.Date;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月7日
 * @author xiangning
 * @since JDK1.8
 */
public class ChatRoom {
	
	public static void showMessage( User user , String message ) {
		System.out.println(new Date().toString() + " -> [" + user.getName() + "] : " + message);
	}

}
