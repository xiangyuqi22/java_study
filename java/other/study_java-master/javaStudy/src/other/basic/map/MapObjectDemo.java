package other.basic.map;

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
 * @version 1.0 2019��9��4��
 * @author xiangning
 * @since JDK1.8
 */
public class MapObjectDemo {
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		User user = new User();
		user.setName("libai");
		map.put("user",user);
		
		user.setName("dufu");
		
		System.out.println(map);
	}

}
