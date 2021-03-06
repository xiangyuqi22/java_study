package com.study.excel.easyexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

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
	
	
	public static void main(String[] args) throws FileNotFoundException {
		new AnalysisDemo1().testExcel2003NoModel();
	}
	
	
    public void testExcel2003NoModel() throws FileNotFoundException {
    	FileInputStream fileInputStream = new FileInputStream("E:\\data\\excel\\xxx机顶盒测试报告模板.xlsx");
        try {
            // 解析每行结果在listener中处理
        	ExcelListener listener = new ExcelListener();

            ExcelReader excelReader = new ExcelReader(fileInputStream, null, listener);
            excelReader.read();
        } catch (Exception e) {

        } finally {
            try {
            	fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
