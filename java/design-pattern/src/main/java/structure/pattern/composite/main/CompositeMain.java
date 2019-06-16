package structure.pattern.composite.main;

import java.util.ArrayList;
import java.util.List;

import structure.pattern.composite.Employee;

/**
 * <PRE>

	组合模式（Composite Pattern），又叫部分整体模式，是用于把一组相似的对象当作一个单一的对象。
	组合模式依据树形结构来组合对象，用来表示部分以及整体层次。这种类型的设计模式属于结构型模式，它创建了对象组的树形结构。
	这种模式创建了一个包含自己对象组的类。该类提供了修改相同对象组的方式。
	我们通过下面的实例来演示组合模式的用法。实例演示了一个组织中员工的层次结构。
	
	意图：
		将对象组合成树形结构以表示"部分-整体"的层次结构。
		组合模式使得用户对单个对象和组合对象的使用具有一致性。

	主要解决：
		它在我们树型结构的问题中，模糊了简单元素和复杂元素的概念，客户程序可以向处理简单元素一样来处理复杂元素，从而使得客户程序与复杂元素的内部结构解耦。
	
	何时使用：
	 	1、您想表示对象的部分-整体层次结构（树形结构）。
	  	2、您希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。 
	
	如何解决：
		树枝和叶子实现统一接口，树枝内部组合该接口。
	
	关键代码：
		树枝内部组合该接口，并且含有内部属性 List，里面放 Component。
	
	应用实例： 
		1、算术表达式包括操作数、操作符和另一个操作数，其中，另一个操作符也可以是操作数、操作符和另一个操作数。 
		2、在 JAVA AWT 和 SWING 中，对于 Button 和 Checkbox 是树叶，Container 是树枝。 
	
	优点： 
		1、高层模块调用简单。 
		2、节点自由增加。 
	
	缺点：
		在使用组合模式时，其叶子和树枝的声明都是实现类，而不是接口，违反了依赖倒置原则。
	
	使用场景：
		部分、整体场景，如树形菜单，文件、文件夹的管理。
	
	注意事项：
		定义时为具体类。

	扩展：可定义接口list来实现，并不是非得当前对象

 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月29日
 * @author xiangning
 * @since JDK1.8
 */
public class CompositeMain {
	
	public static void main(String[] args) {
		
		Employee songjiang = new Employee("宋江", "董事", 1000000);
		Employee lujunyi = new Employee("卢俊义", "董事", 900000);
		
		Employee wusong = new Employee("武松", "经理", 500000);
		songjiang.addSubordinates(wusong);
		Employee linchong = new Employee("林冲", "经理", 600000);
		songjiang.addSubordinates(linchong);
		
		
		Employee yanqing = new Employee("燕青", "经理", 450000);
		lujunyi.addSubordinates(yanqing);
		Employee shixiu = new Employee("石秀", "经理", 400000);
		lujunyi.addSubordinates(shixiu);
		
		
		Employee shien = new Employee("施恩", "科长", 150000);
		wusong.addSubordinates(shien);
		Employee duerniang = new Employee("杜二娘", "科长", 140000);
		wusong.addSubordinates(duerniang);
		Employee zhangqing = new Employee("张青", "科长", 130000);
		wusong.addSubordinates(zhangqing);
		
		
		Employee luzhisheng = new Employee("鲁智深", "科长", 250000);
		linchong.addSubordinates(luzhisheng);
		Employee chaijing = new Employee("柴进", "科长", 150000);
		linchong.addSubordinates(chaijing);
		
		Employee huarong = new Employee("花荣", "科长", 140000);
		yanqing.addSubordinates(huarong);
		Employee zhangshun = new Employee("张顺", "科长", 130000);
		yanqing.addSubordinates(zhangshun);
		
		Employee yangxiong = new Employee("杨雄", "科长", 1110000);
		shixiu.addSubordinates(yangxiong);
		Employee shiqian = new Employee("时迁", "科长", 120000);
		shixiu.addSubordinates(shiqian);
		
		
//		songjiang.showSubordinates();
		
//		System.out.println(lujunyi.showSubordinates2());
		
		showSubordinates(songjiang  , null);
		
		Employee huangdi = new Employee("皇帝", "CEO", 100000000);
		huangdi.addSubordinates(songjiang);
		huangdi.addSubordinates(lujunyi);
		System.out.println("------------------------------------------------------------");
		showSubordinates(huangdi  , null);
		
		List<List<Employee>> empList = new ArrayList<List<Employee>>();
		
		System.out.println("宋江的上级是 :" + songjiang.getSuperior().getName());
		
//		huangdi.removeSubordinates(songjiang);
		
		System.out.println("------------------------------------------------------------");
		System.out.println(huangdi.getSuperior2());
		
		System.out.println("------------------------------------------------------------");
		
		System.out.println(yanqing.getSuperior2());
		
		System.out.println("------------------------------------------------------------");
		showSubordinates(yanqing, null);
		
		
		
	}
	
	public static void showSubordinates(Employee emp , String str) {
		if(str == null) {
			str = "";
		}else {
			str = str + ">";
		}
		System.out.println(str + emp.getName() + "，薪水是:" + emp.getSalary() + "----" + emp.getSuperior2()
		);
		for (Employee emp1 : emp.getSubordinates()) {
			showSubordinates(emp1,str);
		}
//		if(!emp.getSubordinates().isEmpty())  {
//			System.out.println(str + emp.getName());
//		}
	}
	
	
//	public static List<List<Employee>> get(List<List<Employee>> empList, Employee emp){
//		List<List<Employee>> empList2 = new ArrayList<List<Employee>>();
//		for (Employee emp1 : emp.getSubordinates()) {
//			
//		}
//	}
	
	
	

}
