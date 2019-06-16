package com.study.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * <PRE>
 * 全局通用工具类
 * </PRE>
 *
 * 项目名称：stbrecorder</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月7日
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
	 * cloneObject:(深度克隆对象)
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
			// 从流里读出来
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
