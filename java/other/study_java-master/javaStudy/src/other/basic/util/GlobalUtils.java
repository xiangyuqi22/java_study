package other.basic.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��24��
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
//					LOG.error("�ر����쳣", e);
				}
			}
		}
	}
	
	
	/**
	 * cloneObject:(���Կ�¡����)
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
//			LOG.error("ScriptExecuteRecordData --> �����¡�쳣");
		}finally {
			closeStream(bo,oo,bi,oi);
		}
		return null;
	}
	

}
