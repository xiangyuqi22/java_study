package other.basic.innerClass;

import other.basic.innerClass.D.F;

/**
 * <PRE>
 * �ڲ����̳�
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��1��
 * @author xiangning
 * @since JDK1.8
 */
public class MultipleInheritanceDemo {
	
	public static void main(String[] args) {
		D d = new D();
		d.aSay();
		d.bSay();
		d.cSay();
		
		F f = new D.F();
		f.fSay();
		
	}

}


class A {
	public void aSay() {
		System.out.println("����a");
	}
}

class B {
	public void bSay() {
		System.out.println("����b");
	}
}

class C {
	public void cSay() {
		System.out.println("����c");
	}
}

class D extends A{
	
	public void bSay() {
		new E().bSay();
	}
	
	public void cSay() {
		new F().cSay();
	}
	
	public class E extends B{
		
	}
	
	public static class F extends C{
		
		public void fSay() {
			System.out.println("����F");
		}
	}
	
}








