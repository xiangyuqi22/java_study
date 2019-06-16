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
public class CallBack{
	public void doing(ICallback deal) {
		System.out.println("无论是谁传过来的任务，我都会在这里进行处理，处理完了之后 再返回回去结果");
		deal.doingOver(deal);
	}
}
