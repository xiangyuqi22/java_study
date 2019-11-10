package other.basic.java.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��9��27��
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
