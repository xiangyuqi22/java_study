package structure.pattern.composite.main;

import java.util.ArrayList;
import java.util.List;

import structure.pattern.composite.Employee;

/**
 * <PRE>

	���ģʽ��Composite Pattern�����ֽв�������ģʽ�������ڰ�һ�����ƵĶ�����һ����һ�Ķ���
	���ģʽ�������νṹ����϶���������ʾ�����Լ������Ρ��������͵����ģʽ���ڽṹ��ģʽ���������˶���������νṹ��
	����ģʽ������һ�������Լ���������ࡣ�����ṩ���޸���ͬ������ķ�ʽ��
	����ͨ�������ʵ������ʾ���ģʽ���÷���ʵ����ʾ��һ����֯��Ա���Ĳ�νṹ��
	
	��ͼ��
		��������ϳ����νṹ�Ա�ʾ"����-����"�Ĳ�νṹ��
		���ģʽʹ���û��Ե����������϶����ʹ�þ���һ���ԡ�

	��Ҫ�����
		�����������ͽṹ�������У�ģ���˼�Ԫ�غ͸���Ԫ�صĸ���ͻ�������������Ԫ��һ����������Ԫ�أ��Ӷ�ʹ�ÿͻ������븴��Ԫ�ص��ڲ��ṹ���
	
	��ʱʹ�ã�
	 	1�������ʾ����Ĳ���-�����νṹ�����νṹ����
	  	2����ϣ���û�������϶����뵥������Ĳ�ͬ���û���ͳһ��ʹ����Ͻṹ�е����ж��� 
	
	��ν����
		��֦��Ҷ��ʵ��ͳһ�ӿڣ���֦�ڲ���ϸýӿڡ�
	
	�ؼ����룺
		��֦�ڲ���ϸýӿڣ����Һ����ڲ����� List������� Component��
	
	Ӧ��ʵ���� 
		1���������ʽ����������������������һ�������������У���һ��������Ҳ�����ǲ�����������������һ���������� 
		2���� JAVA AWT �� SWING �У����� Button �� Checkbox ����Ҷ��Container ����֦�� 
	
	�ŵ㣺 
		1���߲�ģ����ü򵥡� 
		2���ڵ��������ӡ� 
	
	ȱ�㣺
		��ʹ�����ģʽʱ����Ҷ�Ӻ���֦����������ʵ���࣬�����ǽӿڣ�Υ������������ԭ��
	
	ʹ�ó�����
		���֡����峡���������β˵����ļ����ļ��еĹ���
	
	ע�����
		����ʱΪ�����ࡣ

	��չ���ɶ���ӿ�list��ʵ�֣������Ƿǵõ�ǰ����

 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��29��
 * @author xiangning
 * @since JDK1.8
 */
public class CompositeMain {
	
	public static void main(String[] args) {
		
		Employee songjiang = new Employee("�ν�", "����", 1000000);
		Employee lujunyi = new Employee("¬����", "����", 900000);
		
		Employee wusong = new Employee("����", "����", 500000);
		songjiang.addSubordinates(wusong);
		Employee linchong = new Employee("�ֳ�", "����", 600000);
		songjiang.addSubordinates(linchong);
		
		
		Employee yanqing = new Employee("����", "����", 450000);
		lujunyi.addSubordinates(yanqing);
		Employee shixiu = new Employee("ʯ��", "����", 400000);
		lujunyi.addSubordinates(shixiu);
		
		
		Employee shien = new Employee("ʩ��", "�Ƴ�", 150000);
		wusong.addSubordinates(shien);
		Employee duerniang = new Employee("�Ŷ���", "�Ƴ�", 140000);
		wusong.addSubordinates(duerniang);
		Employee zhangqing = new Employee("����", "�Ƴ�", 130000);
		wusong.addSubordinates(zhangqing);
		
		
		Employee luzhisheng = new Employee("³����", "�Ƴ�", 250000);
		linchong.addSubordinates(luzhisheng);
		Employee chaijing = new Employee("���", "�Ƴ�", 150000);
		linchong.addSubordinates(chaijing);
		
		Employee huarong = new Employee("����", "�Ƴ�", 140000);
		yanqing.addSubordinates(huarong);
		Employee zhangshun = new Employee("��˳", "�Ƴ�", 130000);
		yanqing.addSubordinates(zhangshun);
		
		Employee yangxiong = new Employee("����", "�Ƴ�", 1110000);
		shixiu.addSubordinates(yangxiong);
		Employee shiqian = new Employee("ʱǨ", "�Ƴ�", 120000);
		shixiu.addSubordinates(shiqian);
		
		
//		songjiang.showSubordinates();
		
//		System.out.println(lujunyi.showSubordinates2());
		
		showSubordinates(songjiang  , null);
		
		Employee huangdi = new Employee("�ʵ�", "CEO", 100000000);
		huangdi.addSubordinates(songjiang);
		huangdi.addSubordinates(lujunyi);
		System.out.println("------------------------------------------------------------");
		showSubordinates(huangdi  , null);
		
		List<List<Employee>> empList = new ArrayList<List<Employee>>();
		
		System.out.println("�ν����ϼ��� :" + songjiang.getSuperior().getName());
		
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
		System.out.println(str + emp.getName() + "��нˮ��:" + emp.getSalary() + "----" + emp.getSuperior2()
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
