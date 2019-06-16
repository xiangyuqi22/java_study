package com.study.excel.easyexcel.importexcel;

import java.io.IOException;
import java.util.List;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.study.excel.bean.BugCount;
import com.study.excel.bean.BugInfo;

import static com.study.excel.easyexcel.AnalysisDemo3.*;

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
public class ImportExcel2 {
	
	public static void main(String[] args) throws IOException {
		simpleReadJavaModelV2007();
	}
	
	public static void simpleReadJavaModelV2007() throws IOException {
		List<Object> data = EasyExcelFactory.read(fileInputStream, new Sheet(2, 2, BugInfo.class));
		fileInputStream.close();
		for (Object object : data) {
			System.out.println(object);
		}
	}


}
