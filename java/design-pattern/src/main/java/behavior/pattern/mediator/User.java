package behavior.pattern.mediator;
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
