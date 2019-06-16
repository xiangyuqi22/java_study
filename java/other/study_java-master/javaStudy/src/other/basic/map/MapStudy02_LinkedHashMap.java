package other.basic.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <PRE>
	
	ѧϰ��ַ��
		https://www.cnblogs.com/lzq198754/p/5780165.html
	
	
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��26��
 * @author xiangning
 * @since JDK1.8
 */
public class MapStudy02_LinkedHashMap {
	
	public static void main(String[] args) {
		
		{
			Map<String,String> map = MapUtils.getStringMap();
			System.out.println(map);
		}
		{
			Map<String,String> map = MapUtils.getLinkedHashMap();
			System.out.println(map);
		}
		
		
		
		
	}

}
