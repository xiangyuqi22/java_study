package other.basic.java.set;

import java.util.Comparator;
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
 * @version 1.0 2019��5��30��
 * @author xiangning
 * @since JDK1.8
 */
public class TreeSetDemo01 {
	
	public static void main(String[] args) {
		TreeSet<String> treeSet = SetUtils.getTreeSetData();
		System.out.println(treeSet);
		
	}

}
