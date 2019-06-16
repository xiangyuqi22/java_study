package other.basic.innerClass;

import other.basic.innerClass.D.F;

/**
 * <PRE>
 * 内部类多继承
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月1日
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
		System.out.println("我是a");
	}
}

class B {
	public void bSay() {
		System.out.println("我是b");
	}
}

class C {
	public void cSay() {
		System.out.println("我是c");
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
			System.out.println("我是F");
		}
	}
	
}








