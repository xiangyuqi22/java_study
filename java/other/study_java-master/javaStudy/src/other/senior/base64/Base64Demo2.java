package other.senior.base64;

import java.io.IOException;

import sun.misc.BASE64Decoder;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年8月14日
 * @author xiangning
 * @since JDK1.8
 */
public class Base64Demo2 {
	
	public static void main(String[] args) throws IOException {
		
		
		String data = "eyJmcm9tIjoic3RiaW50ZXIiLCJlbWFpbCI6InhpYW5nbmluZ0BnZG0uY29tIiwiZGVwdCI6ItTL06qyvyIsInRpbWUiOiIxNTkzMjQzNDMyMyJ9";
		data = "eyJ0aW1lIjoiMTU2NTc3MjI2MTU0OCIsInNEZXB0TmFtZSI6Ir+tzai/xry8IiwiYWNjb3VudCI6Im5vY2prdGVzdCIsInNPdXRFbWFpbCI6Imx1b3NoaWxvbmdAZ2RjYXR0c29mdC5jb20ifQ==";
		data = "eyJ0aW1lIjoiMTU2NTc3MjI2MTU0OCIsInNEZXB0TmFtZSI6IuWHr+mAmuenkeaKgCIsImFjY291bnQiOiJub2Nqa3Rlc3QiLCJzT3V0RW1haWwiOiJsdW9zaGlsb25nQGdkY2F0dHNvZnQuY29tIn0=";
		data = "eyJ0aW1lIjoiMTU2NTc3MzY4ODk1MSIsImVtYWlsIjoibHVvc2hpbG9uZ0BnZGNhdHRzb2Z0LmNvbSIsImFjY291bnQiOiJub2Nqa3Rlc3QiLCJkZXB0Ijoi5Yev6YCa56eR5oqAIn0=";
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytes = decoder.decodeBuffer(data);
		System.out.println("BASE64解密：" + new String(bytes,"UTF-8"));
		
		
	}

}
