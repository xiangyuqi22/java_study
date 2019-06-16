package other.basic.java.clone;

import java.util.HashMap;
import java.util.Map;

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
public class CloneDemo1 {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Map<String,User> map = new HashMap<>();
		User user1 = new User();
		map.put("user1", user1);
		{
		}
		{
			User user = new User();
			map.put("user2", user);
		}
		
		
		{
			User user = map.get("user1").clone();
			System.out.println(user);
			System.out.println(map.get("user1")  == user);
			user.setName("dufu");
			user1.setName("libai");
			System.out.println(user);
			System.out.println(map.get("user1"));
		}
		{
			User user11 = user1.clone();
			User user22 = user1.clone();
		}
		
	}

}



