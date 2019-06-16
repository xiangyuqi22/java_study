package behavior.pattern.nullobject;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月9日
 * @author xiangning
 * @since JDK1.8
 */
public class NullCustomer extends AbstractCustomer {

	public NullCustomer() {
		super("");
	}

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public String getName() {
		return "没有梁山好汉的名字";
	}

}
