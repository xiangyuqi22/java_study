package com.cattsoft.ai;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

/**
 * <PRE>
 * ͨ������ʶ��
 * </PRE>
 *
 * ��Ŀ���ƣ�baiduai</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��2��13��
 * @author xiangning
 * @since JDK1.8
 */
public class SimpleDemo {
	//����APPID/AK/SK
    public static final String APP_ID = "15525667";
    public static final String API_KEY = "CFYFxIQNGle9WIvcHMOVHG7s";
    public static final String SECRET_KEY = "na9rg5DDo3C2GSxNPOmnfVRQSuBhIBqc";
	
	public static void main(String[] args) {
		 // ��ʼ��һ��AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        	
        // ��ѡ�������������Ӳ���
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        sample(client);
	}
	
	public static void sample(AipOcr client) {
	    // �����ѡ�������ýӿ�
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("language_type", "CHN_ENG");
	    options.put("detect_direction", "true");
	    options.put("detect_language", "true");
	    options.put("probability", "true");
	    
	    
	    // ����Ϊ����·��
	   // String image = "E:\\data\\temp\\set\\set (5).jpg";
//	    String image = "E:\\data\\temp\\tv (4).png";
	    String image = "E:\\eclipse\\workspaces\\STP\\STP_interface\\stbrecorder\\target\\classes\\data\\file\\temp\\content_img20190213143810.jpg";
	    JSONObject res = client.basicGeneral(image, options);
	    System.out.println(res.toString(2));

	    // ����Ϊ����������
	   /* byte[] file = readFile("test.jpg");
	    res = client.basicGeneral(file, options);
	    System.out.println(res.toString(2));*/
	    
	    // ͨ������ʶ��, ͼƬ����ΪԶ��urlͼƬ
	    /*JSONObject res = client.basicGeneralUrl(url, options);
	    System.out.println(res.toString(2));*/

	}
	
	
}
