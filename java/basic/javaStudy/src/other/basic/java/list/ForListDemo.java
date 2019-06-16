package other.basic.java.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月1日
 * @author xiangning
 * @since JDK1.8
 */
public class ForListDemo {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		ListUtils.getStringList(list);
		
		for (String string : list) {
			System.out.print(string + "\t");
		}
		System.out.println();
		
		while(list.size() > 0 ) {
			for (String string : new ArrayList<String>(list)) {
				boolean remove = list.remove(string);
				System.out.println("remove = " + remove);
			}
		}
		
		System.out.println("移除list元素，使用新创建的list进行移除-----------");
		ListUtils.getStringList(list);
		for (String string : new ArrayList<>(list)) {
			if(string.length() == 2) {
				list.remove(string);
			}
		}
		System.out.println(list);
		
		System.out.println("移除list元素，使用新创建的list进行移除-----------");
		ListUtils.getStringList(list);
		for (String string : new CopyOnWriteArrayList<>(list)) {
			if(string.length() == 2) {
				list.remove(string);
			}
		}
		System.out.println(list);
		
		System.out.println("移除list元素，使用最大值 往小值 移动");
		list.clear();
		ListUtils.getStringList(list);
		for (int i = list.size()-1 ; i >= 0 ; i--) {
			String string = list.get(i);
			if(string.length() == 2) {
				list.remove(string);
			}
		}
		System.out.println(list);
		
		System.out.println("移除list元素，使用迭代器遍历 ");
		list.clear();
		ListUtils.getStringList(list);
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().length() == 2) {
				iterator.remove();
			}
		}
		System.out.println(list);
		
		System.out.println("移除list元素，使用迭代器遍历 ");
		list.clear();
		ListUtils.getStringList(list);
		
		
		
	}

}
