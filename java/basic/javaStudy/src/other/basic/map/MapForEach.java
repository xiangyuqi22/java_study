package other.basic.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��3��8��
 * @author xiangning
 * @since JDK1.8
 */
public class MapForEach {

		public static void main(String[] args) {
			Map<String , String> map  =  new HashMap<>();
			map.put("name", "����");
			map.put("fav", "����");
			map.put("age", "����");
			map.forEach((k,v) ->  System.out.println(k + v) );
			map.forEach((k,v) ->  syso(k,v) );
			
			System.out.println("----------------------------------");
			map.forEach((k,v) -> {
				System.out.println("key = " + k + "; value = " + v);
			});
		}
		
		public static void syso(String k,String v) {
			System.out.println(k);
			System.out.println(v);
		}
}
