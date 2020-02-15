package com.study.algorithm.hashtable;

import org.junit.Test;

import com.study.algorithm.entity.Staff;

/**
 * <PRE>
 * ����������ɢ�б�
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * 
 * @version 1.0 2020��2��14��
 * @author xiangning
 * @since JDK1.8
 */
public class HashTabDemo {
	
	@Test
	public void hashTabDemoTest1() {
		
//		Staff staff = new Staff(1,"libai","��",29);
		
		HashTab<String, Staff> hashTab = new HashTab<String,Staff>(10);
		hashTab.put("1", new Staff(1,"���","��",29));
		hashTab.put("2", new Staff(2,"�Ÿ�","��",33));
		hashTab.put("3", new Staff(3,"������","��",23));
		hashTab.put("4", new Staff(4,"����","��",23));
		hashTab.put("7", new Staff(4,"����","��",23));
		hashTab.put("5", new Staff(5,"������","��",23));
		hashTab.put("6", new Staff(6,"����","��",23));
		hashTab.put("12", new Staff(12,"����","��",39));
		hashTab.put(null, new Staff(12,"����","��",39));
		hashTab.show();
		
		Staff staff = hashTab.get(null);
		System.out.println(staff);
		
		
		
		
		
	}
	
	

}









