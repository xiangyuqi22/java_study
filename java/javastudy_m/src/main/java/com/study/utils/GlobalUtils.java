package com.study.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * <PRE>
 * ȫ��ͨ�ù�����
 * </PRE>
 *
 * ��Ŀ���ƣ�stbrecorder</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��7��
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
				}
			}
		}
	}

	//
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}

	
	/**
	 * cloneObject:(��ȿ�¡����)
	 * @author xiangning
	 *
	 * @param obj
	 * @return
	 */
	public static Object cloneObject(Object obj) {
		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		try {
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			// �����������
			bi = new ByteArrayInputStream(bo.toByteArray());
			oi = new ObjectInputStream(bi);
			return oi.readObject();
		} catch (Exception e) {
		}finally {
			closeStream(bo,oo,bi,oi);
		}
		return null;
	}
}
