package com.study.excel.easyexcel.demo1;

import java.util.List;

import com.study.excel.easyexcel.ExcelUtil;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��14��
 * @author xiangning
 * @since JDK1.8
 */
public class AnalysisDemo1 {
	
	public static void main(String[] args) {
		String filePath = "E:\\data\\excel\\xxx�����в��Ա���ģ��.xlsx";
		 List<Object> objects = ExcelUtil.readLessThan1000Row(filePath);
		 System.out.println(objects);
	}

}
