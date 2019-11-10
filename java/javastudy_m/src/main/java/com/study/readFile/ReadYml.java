package com.study.readFile;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年2月16日
 * @author xiangning
 * @since JDK1.8
 */


import java.io.InputStream;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;


/**
 * <PRE>
 * 读取yml文件的配置信息
 * 	yml不支持中文读取
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年2月16日
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
    				//写入对象，只能读取到英文，中文读取失败
    			}
    			
    			//TestEntity testEntity = yaml.loadAs(DemoApplicationTests.class.getResourceAsStream("/test.yml"), TestEntity.class);//如果读入Map,这里可以是Mapj接口,默认实现为LinkedHashMap
        } catch (Exception e) {
        	System.out.println("文件读取失败");
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
    				//写入对象，只能读取到英文，中文读取失败
    			}
    			//TestEntity testEntity = yaml.loadAs(DemoApplicationTests.class.getResourceAsStream("/test.yml"), TestEntity.class);//如果读入Map,这里可以是Mapj接口,默认实现为LinkedHashMap
        } catch (Exception e) {
        	System.out.println("文件读取失败");
            e.printStackTrace();
        }
	}
}
