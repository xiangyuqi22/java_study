package j2ee.pattern.frontcontroller;

import java.util.HashMap;
import java.util.Map;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��16��
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
			System.out.println("�������");
		}
		View view = maps.get(request.toUpperCase());
		if(view == null) {
			System.out.println("�������");
		}else {
			view.show();
		}
	}
	
	

}
