package com.cattsoft.ai;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.imageclassify.AipImageClassify;



/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：baiduai</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年2月2日
 * @author zhongjie
 * @since JDK1.8
 */
public class LogoDemo2 {
	//设置APPID/AK/SK
    public static final String APP_ID = "15525667";
    public static final String API_KEY = "CFYFxIQNGle9WIvcHMOVHG7s";
    public static final String SECRET_KEY = "na9rg5DDo3C2GSxNPOmnfVRQSuBhIBqc";
    
	public static void main(String[] args) {
		 // 初始化一个AipImageClassifyClient
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        String imgPath = "E:\\data\\temp\\cctv4.jpg";
        logoAdd(client, imgPath);
        //logo(client, imgPath);
	}
	/**
	 * logoAdd:(这里用一句话描述这个方法的作用)
	 * @author zhongjie
	 *
	 * @param client
	 */
	public static void logoAdd(AipImageClassify client, String imgPath) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();

	    String brief = "{\"name\": \"中央电视台4\",\"code\":\"52\"}";

	    // 参数为本地路径
	    JSONObject res = client.logoAdd(imgPath, brief, options);
	    System.out.println(res.toString());

	}
	/**
	 * logo:(这里用一句话描述这个方法的作用)
	 * @author zhongjie
	 *
	 * @param client
	 * @param imgPath
	 */
	public static void logo(AipImageClassify client, String imgPath) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("custom_lib", "false");


	    // 参数为本地路径
	    
	    JSONObject res = client.logoSearch(imgPath, options);
	    System.out.println(res.toString());
	}
}
