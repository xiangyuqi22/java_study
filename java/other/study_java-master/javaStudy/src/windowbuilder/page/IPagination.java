package windowbuilder.page;

import javax.swing.JPanel;

/**
 * <PRE>
 * 分页回调接口
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月24日
 * @author xiangning
 * @since JDK1.8
 */
public interface IPagination {
	
	
	public void update(JPanel pagePanel,int rows,int currentPage);

}
