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
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月14日
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
