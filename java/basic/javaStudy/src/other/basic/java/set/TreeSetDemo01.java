package other.basic.java.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * <PRE>
	treeSet比较时，如果compare 相等，即为0时，则后面插入的值会被忽略。它不允许重复。
	如果是-1  则倒序排列
	如果是 1  则正序排列
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月30日
 * @author xiangning
 * @since JDK1.8
 */
public class TreeSetDemo01 {
	
	public static void main(String[] args) {
		TreeSet<String> treeSet = SetUtils.getTreeSetData();
		System.out.println(treeSet);
		
	}

}
