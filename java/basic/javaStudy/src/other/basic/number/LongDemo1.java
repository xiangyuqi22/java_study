package other.basic.number;

import java.util.HashMap;
import java.util.Map;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��24��
 * @author xiangning
 * @since JDK1.8
 */
public class LongDemo1 {
	
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		
		String str = null;
		map.put("num1", str);
		System.out.println(map.get("num1"));
		System.out.println(map.get("num1") instanceof String);
		
		map.put("num1", "11");
		Long num1 = Long.parseLong(map.get("num1"));
		
		System.out.println(num1);
		
		num1 = null;
		long a = num1;
		System.out.println(a);
		
		
	}

}
