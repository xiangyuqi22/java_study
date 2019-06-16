package com.cattsoft.ai;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.imageclassify.AipImageClassify;



/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�baiduai</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��2��2��
 * @author zhongjie
 * @since JDK1.8
 */
public class LogoDemo2 {
	//����APPID/AK/SK
    public static final String APP_ID = "15525667";
    public static final String API_KEY = "CFYFxIQNGle9WIvcHMOVHG7s";
    public static final String SECRET_KEY = "na9rg5DDo3C2GSxNPOmnfVRQSuBhIBqc";
    
	public static void main(String[] args) {
		 // ��ʼ��һ��AipImageClassifyClient
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // ��ѡ�������������Ӳ���
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        String imgPath = "E:\\data\\temp\\cctv4.jpg";
        logoAdd(client, imgPath);
        //logo(client, imgPath);
	}
	/**
	 * logoAdd:(������һ�仰�����������������)
	 * @author zhongjie
	 *
	 * @param client
	 */
	public static void logoAdd(AipImageClassify client, String imgPath) {
	    // �����ѡ�������ýӿ�
	    HashMap<String, String> options = new HashMap<String, String>();

	    String brief = "{\"name\": \"�������̨4\",\"code\":\"52\"}";

	    // ����Ϊ����·��
	    JSONObject res = client.logoAdd(imgPath, brief, options);
	    System.out.println(res.toString());

	}
	/**
	 * logo:(������һ�仰�����������������)
	 * @author zhongjie
	 *
	 * @param client
	 * @param imgPath
	 */
	public static void logo(AipImageClassify client, String imgPath) {
	    // �����ѡ�������ýӿ�
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("custom_lib", "false");


	    // ����Ϊ����·��
	    
	    JSONObject res = client.logoSearch(imgPath, options);
	    System.out.println(res.toString());
	}
}
