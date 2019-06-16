package other.basic.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��26��
 * @author xiangning
 * @since JDK1.8
 */
public class MapUtils {
	
	public static Map<String,String> getStringMap(){
		Map<String,String> map = new HashMap<>();
		setMap(map);
		map.put(null,null);
		map.put(null,"");
		return map;
	}
	
	
	/**
	 * getLinkedHashMap:()
	 * linkedHashMap �� �����hashMap������������ģ���ȡ��Զ�Ҫ��һЩ��ͬʱҲ�Ƿ�ͬ���ģ����̲߳���ȫ�ġ�
	 * 
	 * 
	 * @author xiangning
	 *
	 * @return
	 */
	public static Map<String,String> getLinkedHashMap(){
		Map<String,String> map = new LinkedHashMap<>();
		setMap(map);
		map.put(null,null);
		map.put(null,"");
		return map;
	}
	public static Map<String,String> getTreeMap(){
		Map<String,String> map = new TreeMap<>();
		setMap(map);
		return map;
	}
	
	public static void setMap(Map<String,String> map){
		map.put("libai", "���");
		map.put("litaibai", "���");
		map.put("dufu", "�Ÿ�");
		map.put("baijuyi", "�׾���");
		map.put("sudongpo", "�ն���");
		map.put("songjiang", "�ν�");
		map.put("likui", "����");
		map.put("xiangning",null);
	}
	
	
	

}
