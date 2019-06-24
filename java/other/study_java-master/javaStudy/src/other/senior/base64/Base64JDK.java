package other.senior.base64;

import java.util.UUID;

import jdk.nashorn.internal.objects.Global;
import other.basic.java.utils.GlobalUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��17��
 * @author xiangning
 * @since JDK1.8
 */
public class Base64JDK {
	// private static final String DATA = "xiangning@qq.com";

	public static void main(String[] args) {

		// ���������ʶ
//		String Identification = UUID.randomUUID().toString();

		//
		String username = "xiangning@gdcmcc.com";

		String dept = "�г���";
		
		String loginData = username + "," + dept + "," + System.currentTimeMillis();
		
		
		loginData = "{\"from\":\"stbinter\",\"token\":\"dbsd-fdsf-sevs-32fv-32fs\",\"time\":\"15932434323\"}";
		
		
 		System.out.println(loginData);

		try {
			// BASE64����
			BASE64Encoder encoder = new BASE64Encoder();
			String data = encoder.encode(loginData.getBytes());
			System.out.println("BASE64���ܣ�" + data);
			
//			GlobalUtils.sleep(2000);
			// BASE64����
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bytes = decoder.decodeBuffer(data);
			System.out.println("BASE64���ܣ�" + new String(bytes));

			// ���
			// BASE64���ܣ�Y29tLmJhc2U2NC5kZW1v
			// BASE64���ܣ�com.base64.demo
		} catch (Exception e) {
			System.out.println("BASE64�ӽ����쳣");
			e.printStackTrace();
		}
	}

}
