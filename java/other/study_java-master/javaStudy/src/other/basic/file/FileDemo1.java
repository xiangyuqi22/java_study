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
 * @version 1.0 2019年2月22日
 * @author xiangning
 * @since JDK1.8
 */


public class FileDemo1 {
	public static void main(String[] args) {
		File file=  new File("E:\\data\\temp\\hdmi\\0201\\origin\\_台标_1549071816986111.mp4");
		System.out.println(file.exists());
		System.out.println(file.getName());
		
		String path = file.getAbsolutePath();
		System.out.println(path);
		path = "_台标_1549071816986111.mp4";
		 int index = path.lastIndexOf(File.separatorChar);
		 System.out.println(path.substring(index + 1));
		 
		 
		 System.out.println(File.separator);
		 
		 System.out.println(File.separatorChar);
		
	}
}
