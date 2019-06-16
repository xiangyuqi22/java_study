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
public class ColorFactory extends AbstractorFactory {

	@Override
	public IColor getColor(String color) {
		if("BLACK".equals(color)) {
			return new Black();
		}else if("YELLOW".equals(color)) {
			return new Black();
		}else if("BLUE".equals(color)) {
			return new Black();
		}
		throw new NullPointerException("您选定的颜色不存在");
	}

	@Override
	public IShape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}


}
