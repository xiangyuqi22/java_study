package structure.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��29��
 * @author xiangning
 * @since JDK1.8
 */
public class Employee {
	
	private String name;
	
	private String dept;
	
	private int salary;
	
	private Employee superior;
	
	private List<Employee> subordinates;

	public Employee(String name, String dept, int salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.subordinates = new ArrayList<Employee>();
	}
	
	
	public void addSubordinates(Employee emp) {
		this.subordinates.add(emp);
		emp.superior = this;
	}
	
	public void removeSubordinates(Employee emp) {
		this.subordinates.remove(emp);
		if(emp.superior == this) {
			emp.superior = null;
		}
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", salary=" + salary + ", subordinates=" + subordinates
				+ "]";
	}
	
	public void showSubordinates() {
		if(subordinates.isEmpty()) {
			System.out.println(name + "û������");
		}else {
			for (Employee employee : subordinates) {
				System.out.println(name + "�������У�" + employee.name);
				employee.showSubordinates();
			}
		}
		System.out.println("-----------------------------------------------------------");
		
	}
	
	public String showSubordinates2() {
		if(subordinates.isEmpty()) {
			return name;
		}else {
			String str = "";
			for (Employee employee : subordinates) {
				if(employee.subordinates.isEmpty()) {
					str += employee.name;
				}else {
					str +=  employee.showSubordinates2() + ">" ;
				}
			}
			return str;
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public List<Employee> getSubordinates() {
		return subordinates;
	}


	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}


	public Employee getSuperior() {
		return superior;
	}


	public void setSuperior(Employee superior) {
		this.superior = superior;
	}
	
	public String getSuperior2() {
		if(this.superior == null) {
			return this.name + "�����Ĵ��У�û�����ܹ���";
		}else {
			return this.name + "���ϼ��ǣ� " + this.superior.name;
		}
	}
	
	
	
	
}
