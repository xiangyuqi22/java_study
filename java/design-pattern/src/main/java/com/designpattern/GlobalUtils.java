package com.designpattern;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月24日
 * @author xiangning
 * @since JDK1.8
 */
public class GlobalUtils {
	
	/**
	 * closeStream:(关闭流)
	 * 
	 * @author xiangning
	 *
	 * @param auto
	 */
	public static void closeStream(AutoCloseable... auto) {
		for (AutoCloseable autoCloseable : auto) {
			if (autoCloseable != null) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					System.out.println("关闭流异常");
				}
			}
		}
	}

}
