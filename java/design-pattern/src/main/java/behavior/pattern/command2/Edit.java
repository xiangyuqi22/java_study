package behavior.pattern.command2;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月6日
 * @author xiangning
 * @since JDK1.8
 */
public class Edit extends AbstractOrder {

	@Override
	public void execute() {
		System.out.println("执行一次编辑操作");
	}

	@Override
	public void cancle() {
		System.out.println("撤销当前编辑操作");
	}

}
