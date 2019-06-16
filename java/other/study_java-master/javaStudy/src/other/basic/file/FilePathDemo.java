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
 * @version 1.0 2019��2��25��
 * @author xiangning
 * @since JDK1.8
 */
public class FilePathDemo {
	
	public static void main(String[] args) {
		File file = new File("C:\\Windows\\WinSxS\\amd64_microsoft-windows-ie-ieshims_31bf3856ad364e35_11.0.17134.556_none_6ce5cab219c7856b\\IEShims.dll");
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getPath());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getFreeSpace());
		System.out.println(file.getTotalSpace() / 1024 /1024 /1024);
	}
}
