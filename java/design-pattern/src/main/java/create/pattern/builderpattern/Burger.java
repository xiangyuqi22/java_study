package create.pattern.builderpattern;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月23日
 * @author xiangning
 * @since JDK1.8
 */
public abstract class Burger implements Item{
	
	/**
	 * 使用wrapper包装
	 */
	public Packing packing() {
		return new Wrapper();
	}
	
	
	
}
