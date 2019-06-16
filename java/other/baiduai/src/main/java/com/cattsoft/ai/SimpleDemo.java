package com.cattsoft.ai;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

/**
 * <PRE>
 * 通用文字识别
 * </PRE>
 *
 * 项目名称：baiduai</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年2月13日
 * @author xiangning
 * @since JDK1.8
 */
public class SimpleDemo {
	//设置APPID/AK/SK
    public static final String APP_ID = "15525667";
    public static final String API_KEY = "CFYFxIQNGle9WIvcHMOVHG7s";
    public static final String SECRET_KEY = "na9rg5DDo3C2GSxNPOmnfVRQSuBhIBqc";
	
	public static void main(String[] args) {
		 // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        	
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        sample(client);
	}
	
	public static void sample(AipOcr client) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("language_type", "CHN_ENG");
	    options.put("detect_direction", "true");
	    options.put("detect_language", "true");
	    options.put("probability", "true");
	    
	    
	    // 参数为本地路径
	   // String image = "E:\\data\\temp\\set\\set (5).jpg";
//	    String image = "E:\\data\\temp\\tv (4).png";
	    String image = "E:\\eclipse\\workspaces\\STP\\STP_interface\\stbrecorder\\target\\classes\\data\\file\\temp\\content_img20190213143810.jpg";
	    JSONObject res = client.basicGeneral(image, options);
	    System.out.println(res.toString(2));

	    // 参数为二进制数组
	   /* byte[] file = readFile("test.jpg");
	    res = client.basicGeneral(file, options);
	    System.out.println(res.toString(2));*/
	    
	    // 通用文字识别, 图片参数为远程url图片
	    /*JSONObject res = client.basicGeneralUrl(url, options);
	    System.out.println(res.toString(2));*/

	}
	
	
}
