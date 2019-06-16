package other.basic.callback;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月9日
 * @author xiangning
 * @since JDK1.8
 */
public class Deal implements ICallback{

	public void doing() {
		System.out.println("开始发起任务");
		new CallBack().doing(this);
		System.out.println("发起任务结束 ");
	}
	

	@Override
	public void doingOver(ICallback deal) {
		System.out.println("处理结束了");
		
	}
}
