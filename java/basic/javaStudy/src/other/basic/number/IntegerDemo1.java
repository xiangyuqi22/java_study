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
public class IntegerDemo1 {
	
	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1, 123);
		Integer integer = map.get(1);
		integer = 99;
		System.out.println(map.get(1));
		
		System.out.println("------------------------------------");
		
		Integer a = 999;
		Integer b = a;
		System.out.println(a == b);
		a = 0;
		System.out.println(a == b);
		
	}

}
