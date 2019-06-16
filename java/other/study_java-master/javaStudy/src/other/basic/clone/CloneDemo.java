package other.basic.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import jdk.nashorn.internal.objects.Global;
import other.basic.util.GlobalUtils;

/**
 * <PRE>
 * 对象烤贝
 * 浅拷贝只是表面拷贝，内部的引用还是一样的
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年3月13日
 * @author xiangning
 * @since JDK1.8
 */
public class CloneDemo {

	public static void main(String[] args) throws CloneNotSupportedException, OptionalDataException, ClassNotFoundException, IOException {
		One one = new One();
		System.out.println(one);

		One one1 = one.deepClone();

		one1.two.threeList.clear();
		
		System.out.println(one1);

		System.out.println("one == one1  = " + (one == one1));

		System.out.println("one.two.threeList == one1.two.threeList = " + (one.two.threeList == one1.two.threeList));

		System.out.println(one.two.threeList);
		System.out.println(one1.two.threeList);
	}
	
	
	
	

}

class One implements Cloneable,Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String str = "one";
	Two two = new Two();
	Three three = new Three();
	
	/**
	 * 浅拷贝
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/**
	 * deepClone:(尝试拷贝)
	 * @author xiangning
	 *
	 * @return
	 * @throws IOException
	 * @throws OptionalDataException
	 * @throws ClassNotFoundException
	 */
	public One deepClone() {
		// 将对象写到流里
		Object cloneObject = GlobalUtils.cloneObject(this);
		if(cloneObject != null ) {
			return (One)cloneObject;
		}
		return null;
	}

	@Override
	public String toString() {
		return "One [str=" + str + ", two=" + two + ", three=" + three + "]";
	}

}

class Two implements Serializable{
	String str = "two";
	List<Three> threeList = new ArrayList<>();

	public Two() {
		{
			Three three = new Three();
			three.str += "1";
			threeList.add(three);
		}
		{
			Three three = new Three();
			three.str += "2";
			threeList.add(three);
		}
	}

	@Override
	public String toString() {
		return "Two [str=" + str + ", threeList=" + threeList + "]";
	}

}

class Three implements Serializable{
	String str = "three";

	@Override
	public String toString() {
		return "Three [str=" + str + "]";
	}

}
