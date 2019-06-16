package other.basic.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <PRE>
	
	学习地址：
		https://www.cnblogs.com/lzq198754/p/5780165.html
	
	
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月26日
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
