package create.pattern.factory;

import sun.security.jca.GetInstance;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��16��
 * @author xiangning
 * @since JDK1.8
 */
public class Factory {
	
	public static IShape getShape(String type) {
		IShape shape = null;
		if("CIRCLE".equals(type)) {
			shape = new Circle();
		}else if("SQUARE".equals(type)) {
			shape = new Square();
		}else if ("RECTANGLE".equals(type)) {
			shape = new Rectangle();
		}
		if(shape == null) {
			throw new NullPointerException("û���ҵ���ִ�еĶ���:" + type);
		}
		return shape;
	}

}
