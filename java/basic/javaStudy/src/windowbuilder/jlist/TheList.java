package windowbuilder.jlist;

import java.util.EventListener;
import java.util.EventObject;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��5��
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
