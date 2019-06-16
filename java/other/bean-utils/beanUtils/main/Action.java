package beanUtils.main;

import java.util.ArrayList;
import java.util.List;

import beanUtils.bean.Animal;
import beanUtils.bean.Persion;
import beanUtils.tran.BeanUtils;



/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：demo</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月2日
 * @author xiangning
 * @since JDK1.8
 */
public class Action {
	public static void main(String[] args) {
		Persion p = new Persion();
		p.setName("tom");
		p.setAge(90);
		List<String> list = new ArrayList<>();
		list.add("jack");
		list.add("mi mouse");
		p.setList1(list);
		Animal a = new Animal();
		try {
			BeanUtils.transBeanByAnnotation(p, a ,false,"list1","age");
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Animal a2 = new Animal();
		a2.setAge(100);
		a2.setName("dog");
		a2.setList(list);
		Persion p2 = new Persion();
		try {
			BeanUtils.transBeanByAnnotation(a2, p2 ,true,"name","list1");
			System.out.println(p2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
