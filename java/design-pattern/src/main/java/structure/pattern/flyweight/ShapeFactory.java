package structure.pattern.flyweight;

import java.util.Hashtable;
import java.util.Map;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月2日
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
