package other.basic.file;

import java.io.File;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年2月25日
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
