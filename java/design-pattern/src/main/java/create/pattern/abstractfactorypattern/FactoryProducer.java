package create.pattern.abstractfactorypattern;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月17日
 * @author xiangning
 * @since JDK1.8
 */
public class FactoryProducer {
	
	public static AbstractorFactory getFactory(String choice) {
		if("SHAPE".equals(choice)) {
			return new ShapeFactory();
		}else if("COLOR".equals(choice)) {
			return new ColorFactory();
		}
		throw new NullPointerException("您选定的样式不存在！");
	}
	
	

}
