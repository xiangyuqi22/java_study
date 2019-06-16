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
public  class ShapeFactory extends AbstractorFactory {

	@Override
	public IShape getShape(final String shape) {
		if("CIRCLE".equals(shape)) {
			return new Circle();
		}else if("SQUARE".equals(shape)) {
			return new Square();
		}else if("RECTANGLE".equals(shape)) {
			return new Rectangle();
		}
		throw new NullPointerException("您所选的形状不存在");
	}

	@Override
	public IColor getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

}
