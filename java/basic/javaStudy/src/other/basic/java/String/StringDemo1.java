package other.basic.java.String;

import java.util.UUID;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月11日
 * @author xiangning
 * @since JDK1.8
 */
public class StringDemo1 {
	
	public static void main(String[] args) {
		String originalFilename = "xiangning.zip";
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
		System.out.println(suffix);
		String uuidName = UUID.randomUUID().toString() + suffix;
		System.out.println(uuidName);
	}

}
