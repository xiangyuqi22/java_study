package com.study.regx;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�junit_study</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��3��6��
 * @author xiangning
 * @since JDK1.8
 */
public class RegxStringTest {
	
	/**
	 * regxTest1:(��֤�ַ������Ƿ������ֵ)
	 * @author xiangning
	 *
	 */
	@Test
	public void regxTest1() {
		String pattern = "^.*\\d+.*$";
		String str = "  this num 33 ___44num thisflfjsdlfs��������";
		assertEquals(true, str.matches(pattern));
	}
	
}
