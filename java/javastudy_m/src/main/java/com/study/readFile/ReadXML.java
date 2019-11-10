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
public class ReadXML {

	/**
	 * readXML:(��XML�ļ��ж�ȡ������Ϣ��map)
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
			Element rootElement = document.getRootElement();// ��ȡ���ڵ�
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
	 * writeMapToXML:(��������Ϣ��mapд�뵽xml�ļ���)
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
			map.put("appName", "Ӧ������");
			// 1.�����ĵ�
			Document doc = DocumentHelper.createDocument();
			// 2.��ӱ�ǩ
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

			// ָ���ı���д���ĸ�ʽ��
			OutputFormat format = OutputFormat.createPrettyPrint(); // Ư����ʽ���пո���
			format.setEncoding("UTF-8");

			// 1.����д������
			 writer = new XMLWriter(out, format);

			// 2.д��Document����
			writer.write(doc);

			// 3.�ر���
			writer.close();
		} catch (Exception e) {
			// TODO: �����쳣
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
				// TODO �ر���
				e.printStackTrace();
			}
		}

	}

}
