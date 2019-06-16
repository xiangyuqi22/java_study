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
public class AnalysisDemo3 {

	public static FileInputStream fileInputStream;

	static {
		try {
			fileInputStream = new FileInputStream("E:\\data\\excel\\xxx机顶盒测试报告模板.xlsx");
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
