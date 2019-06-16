package other.basic.java.set;

import java.util.Comparator;
import java.util.HashSet;
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
 * @version 1.0 2019年5月29日
 * @author xiangning
 * @since JDK1.8
 */
public class SetUtils {
	
	public static HashSet<String> getHashSetData(HashSet<String> hashSet){
		hashSet.add("songjiang");
		hashSet.add("lujunyi");
		hashSet.add("likui");
		hashSet.add("dufu");
		hashSet.add("libai");
		return hashSet;
		
	}
	
	public static TreeSet<String> getTreeSetData(){
		TreeSet<String> treeSet = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return -1;
			}
		});
		treeSet.add("宋江");
		treeSet.add("卢俊义");
		treeSet.add("李逵");
		treeSet.add("杜甫");
		treeSet.add("李白");
		return treeSet;
		
	}

}
