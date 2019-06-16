package other.basic.util.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import other.basic.java.set.SetUtils;
import other.basic.util.StringUtil;

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
public class StringUtilsDemo {
	
	public static void main(String[] args) {
		{
			System.out.println("����ת�ַ���");
			TreeSet<String> treeSetData = SetUtils.getTreeSetData();
			String string = StringUtils.join(treeSetData, ",");
			System.out.println(string);
		}
		{
			/**
			 * �������ת����list����ô��list���ܽ����Ƴ�������ͬʱ�����е�Ԫ���и���ʱ��listҲ����и���
			 */
			System.out.println("�ַ���ת����");
			TreeSet<String> treeSetData = SetUtils.getTreeSetData();
			String string = StringUtils.join(treeSetData, ",");
			String[] split = string.split(",");
			List<String> list = Arrays.asList(split);
			System.out.println(list);
			Set<String> set = new HashSet<>(list);
			System.out.println(set);
			split[0] = "��";
			System.out.println(list);
			System.out.println(set);
			//������׳�һ���쳣
//			list.remove(0);
			
			
			Stream<String> stream = Arrays.asList(split).stream();
			List<String> list2 = stream.map(s -> {
				
				return s;
			}).collect(Collectors.toList());
			list2.remove(0);
			System.out.println(list2);
		}
		{
			System.out.println("String����  ת long����");
			Vector<String> vector = new Vector<String>();
			vector.add("124323");
			vector.add("fd");
			vector.add("5433");
			vector.add("gd");
			Long[] longArray = StringUtil.getLongArray(vector);
			for (Long long1 : longArray) {
				System.out.println(long1);
			}
		}
		
		{
			Vector<String> vector = new Vector<String>();
			vector.add("124323");
			vector.add("fd");
			vector.add("5433");
			vector.add("gd");
			
			Integer[] integers = StringUtil.getLongArray2(vector, new Integer[vector.size()]);
			for (Integer integer  : integers) {
				System.out.print(integer + "\t");
			}
			System.out.println();
			Long[] longs = StringUtil.getLongArrayNotNull(vector, new Long[vector.size()]);
			for (Long long1 : longs) {
				System.out.print(long1 + "\t");
			}
		}
	}

}
