package com.study.excel.easyexcel.demo1;

import java.util.List;

import com.study.excel.easyexcel.ExcelUtil;

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
public class AnalysisDemo1 {
	
	public static void main(String[] args) {
		String filePath = "E:\\data\\excel\\xxx机顶盒测试报告模板.xlsx";
		 List<Object> objects = ExcelUtil.readLessThan1000Row(filePath);
		 System.out.println(objects);
	}

}
