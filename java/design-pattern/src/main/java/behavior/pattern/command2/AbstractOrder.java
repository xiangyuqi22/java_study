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
public abstract class AbstractOrder {
	
	//执行
	public abstract void execute();
	
	//撤销
	public abstract void cancle();
	
	
	

}
