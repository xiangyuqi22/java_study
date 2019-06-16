package com.study.regx;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：junit_study</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年3月6日
 * @author xiangning
 * @since JDK1.8
 */
public class RegxStringTest {
	
	/**
	 * regxTest1:(验证字符串里是否包含数值)
	 * @author xiangning
	 *
	 */
	@Test
	public void regxTest1() {
		String pattern = "^.*\\d+.*$";
		String str = "  this num 33 ___44num thisflfjsdlfs世界银行";
		assertEquals(true, str.matches(pattern));
	}
	
}
