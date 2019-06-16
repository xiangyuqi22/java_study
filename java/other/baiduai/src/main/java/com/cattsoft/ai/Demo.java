package com.cattsoft.ai;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
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
public class Demo {
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

       /* // ��ѡ�����ô����������ַ, http��socket��ѡһ�����߾�������
        client.setHttpProxy("proxy_host", proxy_port);  // ����http����
        client.setSocketProxy("proxy_host", proxy_port);  // ����socket����

        // ��ѡ������log4j��־�����ʽ���������ã���ʹ��Ĭ������
        // Ҳ����ֱ��ͨ��jvm�����������ô˻�������
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");*/

        // ���ýӿ�
        //String path = "E:\\data\\temp\\set\\set (1).jpg";
        String path = "E:\\data\\temp\\tv (4).png";
        sample(client, path);
     }
    
    
    public static void sample(AipOcr client, String imgPath) {
        // �����ѡ�������ýӿ�
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");
        
        
        // ����Ϊ����·��
        //String image = "test.jpg";
        //�߾���
        JSONObject res = client.basicAccurateGeneral(imgPath, options);
        System.out.println(res.toString(2));

        /*// ����Ϊ����������
        byte[] file = readFile("test.jpg");
        res = client.basicGeneral(file, options);
        System.out.println(res.toString(2));
        
        // ͨ������ʶ��, ͼƬ����ΪԶ��urlͼƬ
        JSONObject res = client.basicGeneralUrl(url, options);*/
        /*System.out.println(res.toString(2));*/

    }
 
 
   
}
