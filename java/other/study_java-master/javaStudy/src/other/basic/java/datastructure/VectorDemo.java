package other.basic.java.datastructure;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��30��
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
		vector2.add("����һ");
		vector2.add("���ڶ�");
		vector2.add("������");
		vector2.add("������");
		vector2.add("������");
		vector2.add("������");
		vector2.add("������");
		
		{
			vector1.add(1, "one");
			System.out.println(vector1);
			vector1.remove(1);
			System.out.println(vector1);
		}
		{
			System.out.println("  boolean addAll(Collection c)   ��ָ�� Collection �е�����Ԫ����ӵ���������ĩβ������ָ�� collection �ĵ����������ص�˳�������ЩԪ�ء�");
			vector1.addAll(vector2);
			System.out.println(vector1);
			System.out.println("");
			vector1.removeAll(vector2);
			System.out.println(vector1);
		}
		{
			System.out.println("  boolean addAll(int index, Collection c)   ��ָ��λ�ý�ָ�� Collection �е�����Ԫ�ز��뵽�������С�");
			vector1.addAll(1, vector2);
			System.out.println(vector1);
			vector1.removeAll(vector2);
			System.out.println(vector1);
		}
		{
			System.out.println("void addElement(Object obj)  ��ָ���������ӵ���������ĩβ�������С���� 1��");
			vector1.addElement("һ��");
			System.out.println(vector1);
			vector1.removeElement("һ��");
			System.out.println(vector1);
		}
		{
			System.out.println("int capacity()  ���ش������ĵ�ǰ������");
			System.out.println(vector1.capacity());
			vector1.trimToSize();
			System.out.println(vector1.capacity());
		}
		{
			System.out.println("void copyInto(Object[] anArray)  ����������������Ƶ�ָ���������С�");
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
			System.out.println("int hashCode() ���ش������Ĺ�ϣ��ֵ��");
			System.out.println(vector1.hashCode());
		}
		{
			System.out.println("int indexOf(Object elem)  ���ش������е�һ�γ��ֵ�ָ��Ԫ�ص������������������������Ԫ�أ��򷵻� -1��");
			System.out.println(vector1.indexOf("friday"));
			System.out.println(vector1.indexOf("Friday"));
			System.out.println("int indexOf(Object elem, int index)  ���ش������е�һ�γ��ֵ�ָ��Ԫ�ص��������� index ���������������δ�ҵ���Ԫ�أ��򷵻� -1��");
			System.out.println(vector1.indexOf("Friday" , 0));
			System.out.println(vector1.indexOf("Friday" , 6));
		}
		{
			System.out.println("void insertElementAt(Object obj, int index)  ��ָ��������Ϊ�������е�������뵽ָ���� index ����");
			vector1.insertElementAt("��", 1);
			System.out.println(vector1);
			vector1.remove(1);
			System.out.println(vector1);
		}
		{
			System.out.println("boolean retainAll(Collection c)  ��ȡ�������ϵĽ��� �ڴ������н�����������ָ�� Collection �е�Ԫ�ء�");
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
			System.out.println(" void setSize(int newSize)   ���ô������Ĵ�С��");
			vector1.setSize(299);
			System.out.println(vector1.size());
			System.out.println(vector1.get(100));
			System.out.println(vector1);
			vector1.setSize(7);
			System.out.println(vector1);
		}
		{	
			System.out.println("List subList(int fromIndex, int toIndex)  ���ش� List �Ĳ�����ͼ��Ԫ�ط�ΧΪ�� fromIndex���������� toIndex������������");
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
