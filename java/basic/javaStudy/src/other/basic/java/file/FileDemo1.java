package other.basic.java.file;

import java.io.File;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年3月28日
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
