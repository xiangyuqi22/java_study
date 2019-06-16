package behavior.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月8日
 * @author xiangning
 * @since JDK1.8
 */
public class Subject {
	
	private List<AbsObserver> list = new ArrayList<AbsObserver>();
	
	private int status ;
	
	public void setStatus(int status) {
		System.out.println("主服务更新了状态:" + status);
		this.status = status;
		changeStatus();
	}
	
	public void attach(AbsObserver absObserver) {
		list.add(absObserver);
	}
	
	public void changeStatus() {
		for (AbsObserver absObserver : list) {
			absObserver.update();
		}
	}
	
	public int getStatus() {
		return status;
	}

}
