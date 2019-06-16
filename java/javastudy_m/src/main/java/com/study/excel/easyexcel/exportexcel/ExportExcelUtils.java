package com.study.excel.easyexcel.exportexcel;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;

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
public class ExportExcelUtils {
	
	
	
	/**
	 * simpleReadJavaModelV2007:(读取模板内容)
	 * @author xiangning
	 *
	 * @param sheet
	 * @return
	 * @throws IOException
	 */
	public static List<Object> simpleReadJavaModelV2007(Sheet sheet) throws IOException {
		FileInputStream fileInputStream =  new FileInputStream("E:\\data\\excel\\xxx机顶盒测试报告模板.xlsx");
		List<Object> data = EasyExcelFactory.read(fileInputStream, sheet);
		fileInputStream.close();
		return data;
	}
	
	public static <T>List<T> read(Sheet sheet , T t) throws IOException {
		FileInputStream fileInputStream =  new FileInputStream("E:\\data\\excel\\xxx机顶盒测试报告模板.xlsx");
		List<T> data =  read(fileInputStream, sheet ,  t);
		fileInputStream.close();
		return data;
	}
	
	public static <T>List<T> read(InputStream in, Sheet sheet , T t ) {
        final List<T> rows = new ArrayList<T>();
        new ExcelReader(in, null, new AnalysisEventListener<T>() {
        	
            @Override
            public void invoke(T object, AnalysisContext context) {
                rows.add(object);
                Object currentRowAnalysisResult = context.getCurrentRowAnalysisResult();
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
            	//解析读取完成之后执行
            }
        }, false).read(sheet);
        return rows;
    }


}
