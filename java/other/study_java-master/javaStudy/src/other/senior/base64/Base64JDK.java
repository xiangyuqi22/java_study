package other.senior.base64;

import java.util.UUID;

import jdk.nashorn.internal.objects.Global;
import other.basic.java.utils.GlobalUtils;
import other.basic.util.StringUtil;
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
		
		
		loginData = "{\"from\":\"stbinter\",\"email\":\"xiangning@gdm.com\",\"dept\":\"运营部\",\"time\":\"15932434323\"}";
		loginData = "{\"time\":\"1565772261548\",\"sDeptName\":\"凯通科技\",\"account\":\"nocjktest\",\"sOutEmail\":\"luoshilong@gdcattsoft.com\"}";
		System.out.println(loginData);
		
//		loginData = StringUtil.string2Unicode(loginData);
 		System.out.println(loginData);

		try {
			// BASE64加密
			BASE64Encoder encoder = new BASE64Encoder();
			String data = encoder.encode(loginData.getBytes("UTF-8"));
			System.out.println("=========================================");
			System.out.println(data);
			System.out.println("=========================================");
			
//			GlobalUtils.sleep(2000);
			// BASE64解密
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bytes = decoder.decodeBuffer(data);
			String string = new String(bytes,"UTF-8");
			System.out.println("BASE64解密：" + string);
			
//			string = StringUtil.unicodeToString(string);
			System.out.println("--------------------------------------");
			System.out.println(string);

			// 结果
			// BASE64加密：Y29tLmJhc2U2NC5kZW1v
			// BASE64解密：com.base64.demo
		} catch (Exception e) {
			System.out.println("BASE64加解密异常");
			e.printStackTrace();
		}
	}

}
