package other.basic.java.datastructure;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * <PRE>
	
	字典
	
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月30日
 * @author xiangning
 * @since JDK1.8
 */
public class DictionaryDemo {
	
	public static void main(String[] args) {
		Dictionary<String,String> dictionary = new Hashtable<String,String>();
		dictionary.put("libai", "李白");
		dictionary.put("dufu", "杜甫");
		dictionary.put("baihuyi", "白居易");
		
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
