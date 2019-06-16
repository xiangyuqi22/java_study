package other.basic.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月24日
 * @author xiangning
 * @since JDK1.8
 */
public class GlobalUtils {
	
	public static void closeStream(AutoCloseable... auto) {
		for (AutoCloseable autoCloseable : auto) {
			if (autoCloseable != null) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
//					LOG.error("关闭流异常", e);
				}
			}
		}
	}
	
	
	/**
	 * cloneObject:(尝试克隆对象)
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
//			LOG.error("ScriptExecuteRecordData --> 对象克隆异常");
		}finally {
			closeStream(bo,oo,bi,oi);
		}
		return null;
	}
	

}
