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
public class ExportExcelUtils {
	
	
	
	/**
	 * simpleReadJavaModelV2007:(��ȡģ������)
	 * @author xiangning
	 *
	 * @param sheet
	 * @return
	 * @throws IOException
	 */
	public static List<Object> simpleReadJavaModelV2007(Sheet sheet) throws IOException {
		FileInputStream fileInputStream =  new FileInputStream("E:\\data\\excel\\xxx�����в��Ա���ģ��.xlsx");
		List<Object> data = EasyExcelFactory.read(fileInputStream, sheet);
		fileInputStream.close();
		return data;
	}
	
	public static <T>List<T> read(Sheet sheet , T t) throws IOException {
		FileInputStream fileInputStream =  new FileInputStream("E:\\data\\excel\\xxx�����в��Ա���ģ��.xlsx");
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
            	//������ȡ���֮��ִ��
            }
        }, false).read(sheet);
        return rows;
    }


}
