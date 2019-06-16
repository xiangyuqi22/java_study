package j2ee.pattern.frontcontroller;

import java.util.HashMap;
import java.util.Map;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月16日
 * @author xiangning
 * @since JDK1.8
 */
public class Dispatcher {
	
	private Map<String,View> maps = new HashMap<>();
	
	public Dispatcher() {
		maps.put("HOME", new HomeView());
		maps.put("STUDENT", new StudentView());
	}
	
	
	public void dispatcher(String request) {
		if(request == null ) {
			System.out.println("请求错误");
		}
		View view = maps.get(request.toUpperCase());
		if(view == null) {
			System.out.println("请求错误");
		}else {
			view.show();
		}
	}
	
	

}
