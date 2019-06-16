package structure.pattern.filter.main;

import java.util.ArrayList;
import java.util.List;

import structure.pattern.filter.AndCriteria;
import structure.pattern.filter.Criteria;
import structure.pattern.filter.FemaleCriteria;
import structure.pattern.filter.MaleCriteria;
import structure.pattern.filter.Persion;
import structure.pattern.filter.SingleCriteria;

/**
 * <PRE>
 * 过滤器模式（Filter Pattern）或标准模式（Criteria Pattern）是一种设计模式，这种模式允许开发人员使用不同的标准来过滤一组对象，
 * 通过逻辑运算以解耦的方式把它们连接起来。这种类型的设计模式属于结构型模式，它结合多个标准来获得单一标准。
 * 
 * 学习地址：https://www.runoob.com/design-pattern/filter-pattern.html
 * 
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月27日
 * @author xiangning
 * @since JDK1.8
 */
public class FilterMain {
	
	public static void main(String[] args) {
		List<Persion> persions = new ArrayList<Persion>();
		persions.add(new Persion("宋江" , "male" , "Single"));
		persions.add(new Persion("王英" , "male" , "married"));
		persions.add(new Persion("扈三娘" , "female" , "married"));
		persions.add(new Persion("卢俊义" , "male" , "married"));
		persions.add(new Persion("武松" , "male" , "Single"));
		persions.add(new Persion("林冲" , "male" , "married"));
		persions.add(new Persion("孙二娘" , "female" , "married"));
		persions.add(new Persion("顾大嫂" , "female" , "Single"));
		
		Criteria maleCriteria = new MaleCriteria();
		Criteria femaleCriteria = new FemaleCriteria();
		Criteria singleCriteria = new SingleCriteria();
		AndCriteria andCriteria1 = new AndCriteria(maleCriteria, singleCriteria);
		AndCriteria andCriteria2 = new AndCriteria(new FemaleCriteria(), new SingleCriteria());
		
		
		System.out.println("水浒传中的男性：");
		showPersion(maleCriteria.meetCriteria(persions));
		
		System.out.println("水浒传中的女性：");
		showPersion(femaleCriteria.meetCriteria(persions));
		
		System.out.println("水浒传中单身的好汉：");
		showPersion(singleCriteria.meetCriteria(persions));
		
		System.out.println("水浒传中单身的男英雄：");
		showPersion(andCriteria1.meetCriteria(persions));
		
		System.out.println("水浒传中单身的女英雄：");
		showPersion(andCriteria2.meetCriteria(persions));
		
		
		
		
	}
	
	
	public static void showPersion(List<Persion> persions) {
		persions.forEach((persion) -> {
			System.out.println(persion);
		});
		System.out.println("--------------------------------------- 一共有：" + persions.size() + "位。");
	}

}
