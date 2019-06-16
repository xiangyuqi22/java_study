package com.designpattern;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��24��
 * @author xiangning
 * @since JDK1.8
 */
public class GlobalUtils {
	
	/**
	 * closeStream:(�ر���)
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
					System.out.println("�ر����쳣");
				}
			}
		}
	}

}
