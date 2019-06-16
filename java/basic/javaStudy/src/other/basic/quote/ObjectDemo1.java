package other.basic.quote;

import other.basic.java.bean.User;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月3日
 * @author xiangning
 * @since JDK1.8
 */
public class ObjectDemo1 {
	
	public static void main(String[] args) {
		Persion p = new Persion();
		System.out.println(p.getUser());
		
		User user = p.getUser();
		
		user  = new User();
		user.setName("libai");
		System.out.println(user);
		System.out.println(p);
		
		p.setUser(user);
		System.out.println(p);

	}

}


class Persion{
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Persion [user=" + user + "]";
	}
	
	
	
	
}
