package other.basic.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

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
public class StringUtil {
	
//	public static <T> T[] getArray(Collection<? extends T> t , Class cla) {
//		List<T> collect = t.stream().map(s -> {
//			return Va
//			return s;
//		}).collect(Collectors.toList());
////		T[] array = collect.toArray(new T[collect.size()]);
//		collect.
//		return array;
//	}
	
	
	public static Long[] getLongArray(Collection<String> c) {
		
		List<Long> list = c.stream().map(s -> {
			Long long1 = null;
			try {
				long1 = Long.parseLong(s.trim());
			} catch (NumberFormatException e) {
				System.out.println("ת��ʧ��");
			}
			return long1;
		}).collect(Collectors.toList());
		Long[] longs = list.toArray(new Long[list.size()]);
		return longs;
	}
	
	/**
	 * getLongArray2:(��list������ַ���ת������ֵ���飬֧��ת����Integer Long)
	 * @author xiangning
	 *
	 * @param c
	 * @param t
	 * @return �������飬���ת��ʧ�ܣ��������е�����ΪNULL
	 */
	public static <T> T[] getLongArray2(Collection<String> c , 	T[] t) {
		List<T> list = getList1(c, t , true);
		return list.toArray(t);
	}
	
	/**
	 * getLongArrayNotNull:(ͬ�Ϸ�����Ψһ��ͬ�������ת��ʧ�ܣ������ݽ��������������淵��)
	 * @author xiangning
	 *
	 * @param c
	 * @param t
	 * @return
	 */
	public static <T> T[] getLongArrayNotNull(Collection<String> c , 	T[] t) {
		List<T> list = getList1(c, t , false);
		T[] copyOf = Arrays.copyOf(t, list.size());
		return list.toArray(copyOf);
	}

	
	
	protected static <T> List<T> getList1(Collection<String> c, T[] t , boolean flag) {
		List<T> list = (List<T>) c.stream().map(s -> {
			try {
				if(t.getClass().getSimpleName().contains(Integer.class.getSimpleName())) {
					return Integer.valueOf(s);
				}else if(t.getClass().getSimpleName().contains(Long.class.getSimpleName())) {
					return Long.valueOf(s);
				}
			} catch (Exception e) {
				System.out.println("����ת��ʧ��");
			}
			return null;
		}).collect(Collectors.toList());
		if ( !flag ) {
			Iterator<T> iterator = list.iterator();
			while (iterator.hasNext()) {
				T next = iterator.next();
				if(next == null ) {
					iterator.remove();
				}
			}
		}
		return list;
	}
	
	/**
	 * checkStr:(����ַ�����Ϊ��)
	 * @author xiangning
	 *
	 * @param o1
	 * @return
	 */
	public static boolean checkStr(String o1) {
		if(o1 == null || "".equals(o1)) {
			return false;
		}
		return true;
	}
	

}
