package windowbuilder.jlist;

import java.util.EventListener;
import java.util.EventObject;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月5日
 * @author xiangning
 * @since JDK1.8
 */
public class TheList implements ListSelectionListener {
	
	private String name;
	private Integer age;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "TheList [name=" + name + ", age=" + age + "]";
	}

	public void setValut() {
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println("eeeeeeeeeeee");
	}

	public void valueChanged(ListSelectionListener listSelectionListener) {
		System.out.println("Auto-generated method stub");
		// TODO Auto-generated method stub
		
	}



	
	

}
