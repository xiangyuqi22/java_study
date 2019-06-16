package other.basic.java.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月29日
 * @author xiangning
 * @since JDK1.8
 */
public class HashSetDemo01 {
	
	public static void main(String[] args) {
		{
			System.out.println("HashSet 是无序的------------------------------------");
			HashSet<String> set = new HashSet<String>();
			SetUtils.getHashSetData(set);
			set.forEach(s -> {
				/**
				 * 无序的hashSet
				 */
				System.out.println(s);
			});
			
			System.out.println("spliterator------------------------------------");
			Spliterator<String> spliterator = set.spliterator();
			spliterator.forEachRemaining((s) -> {
				System.out.println(s);
			});
			
			System.out.println("set转换成数组");
			String[] strings = set.toArray(new String[set.size()]);
			System.out.println(strings[0]);
			set.remove("songjiang");
			System.out.println(strings[0]);
			
			System.out.println("数组转换成字符串");
			String string = Arrays.toString(strings);
			System.out.println(string);
			
			System.out.println("数组转换成list");
			List<String> asList = Arrays.asList(strings);
			System.out.println(asList.size());
			
			System.out.println("数组转换成set");
			Set hashSet = new HashSet<>(Arrays.asList(strings));
			System.out.println(hashSet);
			
		}
		
		{
			System.out.println("LinkedHashSet 是有序的------------------------------------");
			float a = 0.75F;
			LinkedHashSet<String> hashSet = new LinkedHashSet<String>();
			SetUtils.getHashSetData(hashSet);
			hashSet.forEach(s -> {
				/**
				 * LinkedHashSet 是有序的
				 */
				System.out.println(s);
			});
			
		}
	}

}
