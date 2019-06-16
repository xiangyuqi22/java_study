package create.pattern.prototypepattern;

import java.util.HashMap;
import java.util.Map;

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
public class ShapeCache {
	
	private static Map<String , Shape> cacheMap = new HashMap<String , Shape>();
	
	static {
		loadCache();
	}
	
	
	public static Shape getShape(String type) {
//		cacheMap.forEach((k,v) ->{
//			System.out.println("k=" + k + ";v=" + v.getId());
//		});
		try {
			return cacheMap.get(type).deepClone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId(1000L);
		{
			Size size = new Size();
			size.setH(100);
			size.setY(200);
			size.setW(300);
			size.setX(400);
			circle.setSize(size);
		}
		cacheMap.put(circle.getType(), circle);
		
		Square square = new Square();
		square.setId(2000L);
		{
			Size size = new Size();
			size.setH(101);
			size.setY(201);
			size.setW(301);
			size.setX(401);
			square.setSize(size);
		}
		cacheMap.put(square.getType(), square);
		
		Rectangle rectangle = new Rectangle();
		rectangle.setId(3000L);
		{
			Size size = new Size();
			size.setH(102);
			size.setY(203);
			size.setW(304);
			size.setX(405);
			rectangle.setSize(size);
		}
		cacheMap.put(rectangle.getType(), rectangle);
		
	}
	

}
