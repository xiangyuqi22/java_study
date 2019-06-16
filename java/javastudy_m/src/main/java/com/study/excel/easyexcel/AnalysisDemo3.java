package com.study.excel.easyexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.study.excel.bean.BugCount;

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
public class AnalysisDemo3 {

	public static FileInputStream fileInputStream;

	static {
		try {
			fileInputStream = new FileInputStream("E:\\data\\excel\\xxx�����в��Ա���ģ��.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		simpleReadJavaModelV2007();
	}

	public static void simpleReadJavaModelV2007() throws IOException {
		List<Object> data = EasyExcelFactory.read(fileInputStream, new Sheet(1, 2, BugCount.class));
		fileInputStream.close();
		for (Object object : data) {
			System.out.println(object);
		}
	}

}
