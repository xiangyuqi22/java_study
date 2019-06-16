package other.basic.file;

import java.io.File;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��2��22��
 * @author xiangning
 * @since JDK1.8
 */


public class FileDemo1 {
	public static void main(String[] args) {
		File file=  new File("E:\\data\\temp\\hdmi\\0201\\origin\\_̨��_1549071816986111.mp4");
		System.out.println(file.exists());
		System.out.println(file.getName());
		
		String path = file.getAbsolutePath();
		System.out.println(path);
		path = "_̨��_1549071816986111.mp4";
		 int index = path.lastIndexOf(File.separatorChar);
		 System.out.println(path.substring(index + 1));
		 
		 
		 System.out.println(File.separator);
		 
		 System.out.println(File.separatorChar);
		
	}
}
