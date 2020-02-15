package com.study.algorithm.hashtable;

import org.junit.Test;

import com.study.algorithm.entity.Staff;

/**
 * <PRE>
 * 功能描述：散列表
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 
 * @version 1.0 2020年2月14日
 * @author xiangning
 * @since JDK1.8
 */
public class HashTabDemo {
	
	@Test
	public void hashTabDemoTest1() {
		
//		Staff staff = new Staff(1,"libai","男",29);
		
		HashTab<String, Staff> hashTab = new HashTab<String,Staff>(10);
		hashTab.put("1", new Staff(1,"李白","男",29));
		hashTab.put("2", new Staff(2,"杜甫","男",33));
		hashTab.put("3", new Staff(3,"辛弃疾","男",23));
		hashTab.put("4", new Staff(4,"杜牧","男",23));
		hashTab.put("7", new Staff(4,"杜牧","男",23));
		hashTab.put("5", new Staff(5,"李商隐","男",23));
		hashTab.put("6", new Staff(6,"李煜","男",23));
		hashTab.put("12", new Staff(12,"张先","男",39));
		hashTab.put(null, new Staff(12,"张先","男",39));
		hashTab.show();
		
		Staff staff = hashTab.get(null);
		System.out.println(staff);
		
		
		
		
		
	}
	
	

}









