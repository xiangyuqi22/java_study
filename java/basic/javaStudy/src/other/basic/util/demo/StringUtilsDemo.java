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
public class StringUtilsDemo {
	
	public static void main(String[] args) {
		{
			System.out.println("集合转字符串");
			TreeSet<String> treeSetData = SetUtils.getTreeSetData();
			String string = StringUtils.join(treeSetData, ",");
			System.out.println(string);
		}
		{
			/**
			 * 如果数组转换成list，那么该list不能进行移除操作。同时数据中的元素有更改时，list也会进行更改
			 */
			System.out.println("字符串转集合");
			TreeSet<String> treeSetData = SetUtils.getTreeSetData();
			String string = StringUtils.join(treeSetData, ",");
			String[] split = string.split(",");
			List<String> list = Arrays.asList(split);
			System.out.println(list);
			Set<String> set = new HashSet<>(list);
			System.out.println(set);
			split[0] = "宋";
			System.out.println(list);
			System.out.println(set);
			//这里会抛出一个异常
//			list.remove(0);
			
			
			Stream<String> stream = Arrays.asList(split).stream();
			List<String> list2 = stream.map(s -> {
				
				return s;
			}).collect(Collectors.toList());
			list2.remove(0);
			System.out.println(list2);
		}
		{
			System.out.println("String集合  转 long数组");
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
