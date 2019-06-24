package other.senior.base64;

import java.util.UUID;

import jdk.nashorn.internal.objects.Global;
import other.basic.java.utils.GlobalUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月17日
 * @author xiangning
 * @since JDK1.8
 */
public class Base64JDK {
	// private static final String DATA = "xiangning@qq.com";

	public static void main(String[] args) {

		// 传入随机标识
//		String Identification = UUID.randomUUID().toString();

		//
		String username = "xiangning@gdcmcc.com";

		String dept = "市场部";
		
		String loginData = username + "," + dept + "," + System.currentTimeMillis();
		
		
		loginData = "{\"from\":\"stbinter\",\"token\":\"dbsd-fdsf-sevs-32fv-32fs\",\"time\":\"15932434323\"}";
		
		
 		System.out.println(loginData);

		try {
			// BASE64加密
			BASE64Encoder encoder = new BASE64Encoder();
			String data = encoder.encode(loginData.getBytes());
			System.out.println("BASE64加密：" + data);
			
//			GlobalUtils.sleep(2000);
			// BASE64解密
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bytes = decoder.decodeBuffer(data);
			System.out.println("BASE64解密：" + new String(bytes));

			// 结果
			// BASE64加密：Y29tLmJhc2U2NC5kZW1v
			// BASE64解密：com.base64.demo
		} catch (Exception e) {
			System.out.println("BASE64加解密异常");
			e.printStackTrace();
		}
	}

}
