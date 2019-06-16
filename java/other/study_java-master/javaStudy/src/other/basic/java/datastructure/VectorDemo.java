package other.basic.java.datastructure;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月30日
 * @author xiangning
 * @since JDK1.8
 */
public class VectorDemo {
	
	public static void main(String[] args) {
		Vector<String> vector1 = new Vector<String>(7);
		vector1.add("Monday");
		vector1.add("Tuesday");
		vector1.add("Wednesday");
		vector1.add("Thursday");
		vector1.add("Friday");
		vector1.add("Saturday");
		vector1.add("Sunday");
		
		Vector<String> vector2 = new Vector<String>(7);
		vector2.add("星期一");
		vector2.add("星期二");
		vector2.add("星期三");
		vector2.add("星期四");
		vector2.add("星期五");
		vector2.add("星期六");
		vector2.add("星期日");
		
		{
			vector1.add(1, "one");
			System.out.println(vector1);
			vector1.remove(1);
			System.out.println(vector1);
		}
		{
			System.out.println("  boolean addAll(Collection c)   将指定 Collection 中的所有元素添加到此向量的末尾，按照指定 collection 的迭代器所返回的顺序添加这些元素。");
			vector1.addAll(vector2);
			System.out.println(vector1);
			System.out.println("");
			vector1.removeAll(vector2);
			System.out.println(vector1);
		}
		{
			System.out.println("  boolean addAll(int index, Collection c)   在指定位置将指定 Collection 中的所有元素插入到此向量中。");
			vector1.addAll(1, vector2);
			System.out.println(vector1);
			vector1.removeAll(vector2);
			System.out.println(vector1);
		}
		{
			System.out.println("void addElement(Object obj)  将指定的组件添加到此向量的末尾，将其大小增加 1。");
			vector1.addElement("一周");
			System.out.println(vector1);
			vector1.removeElement("一周");
			System.out.println(vector1);
		}
		{
			System.out.println("int capacity()  返回此向量的当前容量。");
			System.out.println(vector1.capacity());
			vector1.trimToSize();
			System.out.println(vector1.capacity());
		}
		{
			System.out.println("void copyInto(Object[] anArray)  将此向量的组件复制到指定的数组中。");
			String[] strs = new String[vector1.size()];
			vector1.copyInto(strs);
			for (String string : strs) {
				System.out.print(string + "\t");
			}
			System.out.println();
		}
		{
			String elementAt = vector1.elementAt(0);
			System.out.println(elementAt);
			String string = vector1.get(0);
			System.out.println(string);
			System.out.println(string.equals(elementAt));
		}
		{
			System.out.println("int hashCode() 返回此向量的哈希码值。");
			System.out.println(vector1.hashCode());
		}
		{
			System.out.println("int indexOf(Object elem)  返回此向量中第一次出现的指定元素的索引，如果此向量不包含该元素，则返回 -1。");
			System.out.println(vector1.indexOf("friday"));
			System.out.println(vector1.indexOf("Friday"));
			System.out.println("int indexOf(Object elem, int index)  返回此向量中第一次出现的指定元素的索引，从 index 处正向搜索，如果未找到该元素，则返回 -1。");
			System.out.println(vector1.indexOf("Friday" , 0));
			System.out.println(vector1.indexOf("Friday" , 6));
		}
		{
			System.out.println("void insertElementAt(Object obj, int index)  将指定对象作为此向量中的组件插入到指定的 index 处。");
			vector1.insertElementAt("日", 1);
			System.out.println(vector1);
			vector1.remove(1);
			System.out.println(vector1);
		}
		{
			System.out.println("boolean retainAll(Collection c)  获取两个集合的交集 在此向量中仅保留包含在指定 Collection 中的元素。");
			Vector<String> vector = new Vector<String>();
			Vector<String> vector3 = new Vector<String>();
			vector3.addAll(vector1);
			vector.add("Monday");
			vector.add("Saturday");
			vector.add("Wednesday");
			vector.add("Thursday");
			vector3.retainAll(vector);
			System.out.println(vector3);
		}
		{
			System.out.println(" void setSize(int newSize)   设置此向量的大小。");
			vector1.setSize(299);
			System.out.println(vector1.size());
			System.out.println(vector1.get(100));
			System.out.println(vector1);
			vector1.setSize(7);
			System.out.println(vector1);
		}
		{	
			System.out.println("List subList(int fromIndex, int toIndex)  返回此 List 的部分视图，元素范围为从 fromIndex（包括）到 toIndex（不包括）。");
			List<String> list = vector1.subList(2, 5);
			System.out.println(list);
		}
		{
			String[] strings = vector1.toArray(new String[vector1.size()]);
			for (String string : strings) {
				System.out.print(string + "\t");
			}
		}
		
	}

}
