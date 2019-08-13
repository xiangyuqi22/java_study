package other.basic.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年7月4日
 * @author xiangning
 * @since JDK1.8
 */
public class StringDemo1 {
	
	public static void main(String[] args) {
		
		Map paramMap = new HashMap<>();
		
		
		new ArrayList<>(new HashSet());
		
		
		//根据机顶盒id查询缺陷详情
		//根据机顶盒id查询日志里面的脚本
		
		System.out.println(new HashMap<>().get("a") + "");
		
		String originName = "mystudy.jpg";
		String suffix = originName.substring(originName.lastIndexOf("."),originName.length());
		System.out.println(suffix);
	}

}
