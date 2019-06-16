package other.basic.quote;

import other.basic.java.bean.User;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��3��
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
