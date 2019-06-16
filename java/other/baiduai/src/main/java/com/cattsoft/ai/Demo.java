package com.cattsoft.ai;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
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
public class Demo {
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

       /* // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");*/

        // 调用接口
        //String path = "E:\\data\\temp\\set\\set (1).jpg";
        String path = "E:\\data\\temp\\tv (4).png";
        sample(client, path);
     }
    
    
    public static void sample(AipOcr client, String imgPath) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");
        
        
        // 参数为本地路径
        //String image = "test.jpg";
        //高精度
        JSONObject res = client.basicAccurateGeneral(imgPath, options);
        System.out.println(res.toString(2));

        /*// 参数为二进制数组
        byte[] file = readFile("test.jpg");
        res = client.basicGeneral(file, options);
        System.out.println(res.toString(2));
        
        // 通用文字识别, 图片参数为远程url图片
        JSONObject res = client.basicGeneralUrl(url, options);*/
        /*System.out.println(res.toString(2));*/

    }
 
 
   
}
