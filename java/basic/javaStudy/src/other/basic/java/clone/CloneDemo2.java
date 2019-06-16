package other.basic.java.clone;

import java.util.HashMap;
import java.util.Map;

import other.basic.java.bean.User;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月3日
 * @author xiangning
 * @since JDK1.8
 */
public class CloneDemo2 {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Persion p = new Persion();
		p.user = new User();
		Persion p1 = p.clone();
		p1.user.setName("alibaba");
		Persion p2 = p.clone();
		p2.user.setName("baidu");
		
		p1.map.put("name", "libai");
		
		p2.map.put("name" , "dufu" );
		
		System.out.println(p1);
		
		System.out.println(p2);
		
		
	}

}


class Persion implements Cloneable{
	
	Map<String,String> map = new HashMap<String,String>();
	
	User user;

	@Override
	protected Persion clone() throws CloneNotSupportedException {
		Persion p = (Persion)super.clone();
		p.map = new HashMap<>();
		return p;
	}

	@Override
	public String toString() {
		return "Persion [map=" + map + ", user=" + user + "]";
	}
	
}
