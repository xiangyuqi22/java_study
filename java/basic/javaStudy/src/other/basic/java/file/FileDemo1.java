package other.basic.java.file;

import java.io.File;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��3��28��
 * @author xiangning
 * @since JDK1.8
 */
public class FileDemo1 {
	public static void main(String[] args) {
		String path = "E:\\data\\temp\\11.jpg";
		File file  = new File(path);
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		System.out.println(File.separator);
		System.out.println((double)file.length() / 1024);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
