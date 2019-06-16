package other.basic.java.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * <PRE>

	treeSet�Ƚ�ʱ�����compare ��ȣ���Ϊ0ʱ�����������ֵ�ᱻ���ԡ����������ظ���
	�����-1  ��������
	����� 1  ����������


 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��29��
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
		treeSet.add("�ν�");
		treeSet.add("¬����");
		treeSet.add("����");
		treeSet.add("�Ÿ�");
		treeSet.add("���");
		return treeSet;
		
	}

}
