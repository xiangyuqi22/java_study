package other.basic.java.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年9月27日
 * @author xiangning
 * @since JDK1.8
 */
public class UrlCodeDemo1 {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String url = "http://192.168.104.111:8080/dl-app";
		String key = URLEncoder.encode(url,"utf-8");
		
		System.out.println(key);
		
		String value = URLDecoder.decode(key, "utf-8");
		
		System.out.println(value);
		
		
	}

}
