package create.pattern.factory;

import sun.security.jca.GetInstance;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月16日
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
			throw new NullPointerException("没有找到可执行的对象:" + type);
		}
		return shape;
	}

}
