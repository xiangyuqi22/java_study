package other.basic.java.datastructure;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * <PRE>
	
	�ֵ�
	
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��30��
 * @author xiangning
 * @since JDK1.8
 */
public class DictionaryDemo {
	
	public static void main(String[] args) {
		Dictionary<String,String> dictionary = new Hashtable<String,String>();
		dictionary.put("libai", "���");
		dictionary.put("dufu", "�Ÿ�");
		dictionary.put("baihuyi", "�׾���");
		
		Enumeration<String> enumeration = dictionary.elements();
		while (enumeration.hasMoreElements()) {
			String nextElement = enumeration.nextElement();
			System.out.print(nextElement + "\t");
		}
		
		System.out.println();
		Enumeration<String> keys = dictionary.keys();
		while (keys.hasMoreElements()) {
			System.out.print(keys.nextElement() + "\t");
		}
		System.out.println();
		
		
		
		
		
	}

}
