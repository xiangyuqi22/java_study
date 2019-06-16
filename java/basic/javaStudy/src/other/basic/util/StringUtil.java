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
				System.out.println("转换失败");
			}
			return long1;
		}).collect(Collectors.toList());
		Long[] longs = list.toArray(new Long[list.size()]);
		return longs;
	}
	
	/**
	 * getLongArray2:(将list里面的字符串转换成数值数组，支持转换成Integer Long)
	 * @author xiangning
	 *
	 * @param c
	 * @param t
	 * @return 返回数组，如果转换失败，则数组中的数据为NULL
	 */
	public static <T> T[] getLongArray2(Collection<String> c , 	T[] t) {
		List<T> list = getList1(c, t , true);
		return list.toArray(t);
	}
	
	/**
	 * getLongArrayNotNull:(同上方法，唯一不同的是如果转换失败，该数据将不会在数据里面返回)
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
				System.out.println("类型转换失败");
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
	 * checkStr:(检查字符串不为空)
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
