package structure.pattern.flyweight;

import java.util.Hashtable;
import java.util.Map;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��2��
 * @author xiangning
 * @since JDK1.8
 */
public class ShapeFactory {
	
	private static final Map<String,Shape> shapes = new Hashtable<String,Shape>();
	
	public synchronized static Shape getShape( String color , String type ) {
		String key = color + "_" + type;
		Shape shape = shapes.get(key);
		if(shape == null) {
			if("circle".equalsIgnoreCase(type)) {
				shape = new Circle(10, 11, 12, color);
			}else {
				shape = new Rectangle(21, 22, 23, color);
			}
			shapes.put(key, shape);
		}
		System.out.println(shapes.size());
		return shape;
	}
	

}
