package other.senior.base64;

import java.io.IOException;

import sun.misc.BASE64Decoder;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��8��14��
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
		System.out.println("BASE64���ܣ�" + new String(bytes,"UTF-8"));
		
		
	}

}
