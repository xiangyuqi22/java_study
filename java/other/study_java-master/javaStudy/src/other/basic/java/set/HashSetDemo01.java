package other.basic.java.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��29��
 * @author xiangning
 * @since JDK1.8
 */
public class HashSetDemo01 {
	
	public static void main(String[] args) {
		{
			System.out.println("HashSet �������------------------------------------");
			HashSet<String> set = new HashSet<String>();
			SetUtils.getHashSetData(set);
			set.forEach(s -> {
				/**
				 * �����hashSet
				 */
				System.out.println(s);
			});
			
			System.out.println("spliterator------------------------------------");
			Spliterator<String> spliterator = set.spliterator();
			spliterator.forEachRemaining((s) -> {
				System.out.println(s);
			});
			
			System.out.println("setת��������");
			String[] strings = set.toArray(new String[set.size()]);
			System.out.println(strings[0]);
			set.remove("songjiang");
			System.out.println(strings[0]);
			
			System.out.println("����ת�����ַ���");
			String string = Arrays.toString(strings);
			System.out.println(string);
			
			System.out.println("����ת����list");
			List<String> asList = Arrays.asList(strings);
			System.out.println(asList.size());
			
			System.out.println("����ת����set");
			Set hashSet = new HashSet<>(Arrays.asList(strings));
			System.out.println(hashSet);
			
		}
		
		{
			System.out.println("LinkedHashSet �������------------------------------------");
			float a = 0.75F;
			LinkedHashSet<String> hashSet = new LinkedHashSet<String>();
			SetUtils.getHashSetData(hashSet);
			hashSet.forEach(s -> {
				/**
				 * LinkedHashSet �������
				 */
				System.out.println(s);
			});
			
		}
	}

}
