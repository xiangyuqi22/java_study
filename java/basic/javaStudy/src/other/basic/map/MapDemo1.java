package other.basic.map;

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
 * @version 1.0 2018��12��7��
 * @author xiangning
 * @since JDK1.8
 */
public class MapDemo1 {
	
	public static void main(String[] args) {
		Map map = new HashMap<>();
		if(map.get("a") == null) {
			System.out.println("yes is null");
		}
	}

}
