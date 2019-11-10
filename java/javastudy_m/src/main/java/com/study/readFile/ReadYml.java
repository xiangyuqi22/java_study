package com.study.readFile;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��2��16��
 * @author xiangning
 * @since JDK1.8
 */


import java.io.InputStream;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;


/**
 * <PRE>
 * ��ȡyml�ļ���������Ϣ
 * 	yml��֧�����Ķ�ȡ
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��2��16��
 * @author xiangning
 * @since JDK1.8
 */
public class ReadYml {
	public void readToObject() {
		String fileName = "/yml/test.yml";
		try {
            Yaml yaml = new Yaml();
            InputStream in = ReadYml.class.getClass().getResourceAsStream(fileName);
    			if(in != null) {
    				//yaml.load(in);
    				PersionEntity persion = yaml.loadAs(in, PersionEntity.class);
    				System.out.println(persion.getName());
    				//д�����ֻ�ܶ�ȡ��Ӣ�ģ����Ķ�ȡʧ��
    			}
    			
    			//TestEntity testEntity = yaml.loadAs(DemoApplicationTests.class.getResourceAsStream("/test.yml"), TestEntity.class);//�������Map,���������Mapj�ӿ�,Ĭ��ʵ��ΪLinkedHashMap
        } catch (Exception e) {
        	System.out.println("�ļ���ȡʧ��");
            e.printStackTrace();
        }
	}
	
	
	
	public void readToMap() {
		String fileName = "/yml/test.yml";
		try {
            Yaml yaml = new Yaml();
            InputStream in;
    			in = ReadYml.class.getClass().getResourceAsStream(fileName);
    			if(in != null) {
    				HashMap map = yaml.loadAs(in, HashMap.class);
    				System.out.println(map);
    				//д�����ֻ�ܶ�ȡ��Ӣ�ģ����Ķ�ȡʧ��
    			}
    			//TestEntity testEntity = yaml.loadAs(DemoApplicationTests.class.getResourceAsStream("/test.yml"), TestEntity.class);//�������Map,���������Mapj�ӿ�,Ĭ��ʵ��ΪLinkedHashMap
        } catch (Exception e) {
        	System.out.println("�ļ���ȡʧ��");
            e.printStackTrace();
        }
	}
}
