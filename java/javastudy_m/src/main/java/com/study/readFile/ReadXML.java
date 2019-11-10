package com.study.readFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

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
public class ReadXML {

	/**
	 * readXML:(从XML文件中读取配置信息到map)
	 * 
	 * @author xiangning
	 *
	 */
	public void readXML() {
		SAXReader reader = new SAXReader();
		String fileName = "/xml/test.xml";
		InputStream in = ReadXML.class.getClass().getResourceAsStream(fileName);
		try {
			if (in == null) {
				return;
			}
			Document document = reader.read(in);
			Element rootElement = document.getRootElement();// 获取根节点
			Map<String, String> map = new HashMap<String, String>();
			for (Iterator<?> iterator = rootElement.elementIterator(); iterator.hasNext();) {
				Element element = (Element) iterator.next();
				Attribute key = element.attribute("key");
				Attribute value = element.attribute("value");
				map.put(key.getValue(), value.getValue());
			}
			System.out.println(map);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * writeMapToXML:(将配置信息从map写入到xml文件中)
	 * 
	 * @author xiangning
	 * @throws IOException
	 *
	 */
	public void writeMapToXML() {
		XMLWriter writer = null;
		FileOutputStream out = null;
		try {
			String fileName = "/xml/config.xml";
			Map<String, Object> map = new HashMap();
			map.put("appName", "应用名称");
			// 1.创建文档
			Document doc = DocumentHelper.createDocument();
			// 2.添加标签
			Element rootElem = doc.addElement("root");
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				Element newElement = rootElem.addElement("config");
				newElement.addAttribute("key", entry.getKey());
				newElement.addAttribute("value", entry.getValue().toString());
				System.out.println(newElement);
			}
			URL resource = ReadXML.class.getClass().getResource(fileName);
			if(resource == null) {
				return;
			}
			System.out.println(resource.getPath());
			out = new FileOutputStream(resource.getFile());

			// 指定文本的写出的格式：
			OutputFormat format = OutputFormat.createPrettyPrint(); // 漂亮格式：有空格换行
			format.setEncoding("UTF-8");

			// 1.创建写出对象
			 writer = new XMLWriter(out, format);

			// 2.写出Document对象
			writer.write(doc);

			// 3.关闭流
			writer.close();
		} catch (Exception e) {
			// TODO: 处理异常
			e.printStackTrace();
		}finally{
			try {
				if(writer != null) {
					writer.close();
				}
				if(out != null) {
					out.close();
				}
			} catch (IOException e) {
				// TODO 关闭流
				e.printStackTrace();
			}
		}

	}

}
