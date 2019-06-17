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
 * ����������
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
	
	
	public static void main(String[] args) throws FileNotFoundException {
		new AnalysisDemo1().testExcel2003NoModel();
	}
	
	
    public void testExcel2003NoModel() throws FileNotFoundException {
    	FileInputStream fileInputStream = new FileInputStream("E:\\data\\excel\\xxx�����в��Ա���ģ��.xlsx");
        try {
            // ����ÿ�н����listener�д���
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