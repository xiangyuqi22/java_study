package com.study.excel.easyexcel;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.util.CollectionUtils;
import com.alibaba.excel.util.StringUtils;


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
public class ExcelUtil {

   private static Sheet initSheet;

   static {
      initSheet = new Sheet(1, 0);
      initSheet.setSheetName("sheet");
      //��������Ӧ���
      initSheet.setAutoWidth(Boolean.TRUE);
   }

   /**
    * ��ȡ����1000������
    * @param filePath �ļ�����·��
    * @return
    */
   public static List<Object> readLessThan1000Row(String filePath){
      return readLessThan1000RowBySheet(filePath,null);
   }

   /**
    * ��С��1000������, ����ʽ
    * filePath �ļ�����·��
    * initSheet ��
    *      sheetNo: sheetҳ�룬Ĭ��Ϊ1
    *      headLineMun: �ӵڼ��п�ʼ��ȡ���ݣ�Ĭ��Ϊ0, ��ʾ�ӵ�һ�п�ʼ��ȡ
    *      clazz: ��������List<Object> ��Object������
    */
   public static List<Object> readLessThan1000RowBySheet(String filePath, Sheet sheet){
      if(!StringUtils.hasText(filePath)){
         return null;
      }

      sheet = sheet != null ? sheet : initSheet;

      InputStream fileStream = null;
      try {
         fileStream = new FileInputStream(filePath);
         return EasyExcelFactory.read(fileStream, sheet);
      } catch (FileNotFoundException e) {
         System.out.println("�Ҳ����ļ����ļ�·������, �ļ���{} " + filePath);
      }finally {
         try {
            if(fileStream != null){
               fileStream.close();
            }
         } catch (IOException e) {
            System.out.println("excel�ļ���ȡʧ��, ʧ��ԭ��{}");
         }
      }
      return null;
   }

   /**
    * ������1000������
    * @param filePath �ļ�����·��
    * @return
    */
   public static List<Object> readMoreThan1000Row(String filePath){
      return readMoreThan1000RowBySheet(filePath,null);
   }

   /**
    * ������1000������, ����ʽ
    * @param filePath �ļ�����·��
    * @return
    */
   public static List<Object> readMoreThan1000RowBySheet(String filePath, Sheet sheet){
      if(!StringUtils.hasText(filePath)){
         return null;
      }

      sheet = sheet != null ? sheet : initSheet;

      InputStream fileStream = null;
      try {
         fileStream = new FileInputStream(filePath);
         ExcelListener excelListener = new ExcelListener();
         EasyExcelFactory.readBySax(fileStream, sheet, excelListener);
         return excelListener.getDatas();
      } catch (FileNotFoundException e) {
    	  System.out.println("�Ҳ����ļ����ļ�·������, �ļ���{}");
      }finally {
         try {
            if(fileStream != null){
               fileStream.close();
            }
         } catch (IOException e) {
        	 System.out.println("excel�ļ���ȡʧ��, ʧ��ԭ��{}");
         }
      }
      return null;
   }

   /**
    * ����excle
    * @param filePath  ����·��, �磺/home/chenmingjian/Downloads/aaa.xlsx
    * @param data ����Դ
    * @param head ��ͷ
    */
   public static void writeBySimple(String filePath, List<List<Object>> data, List<String> head){
      writeSimpleBySheet(filePath,data,head,null);
   }

   /**
    * ����excle
    * @param filePath ����·��, �磺/home/chenmingjian/Downloads/aaa.xlsx
    * @param data ����Դ
    * @param sheet excleҳ����ʽ
    * @param head ��ͷ
    */
   public static void writeSimpleBySheet(String filePath, List<List<Object>> data, List<String> head, Sheet sheet){
      sheet = (sheet != null) ? sheet : initSheet;

      if(head != null){
         List<List<String>> list = new ArrayList<>();
         head.forEach(h -> list.add(Collections.singletonList(h)));
         sheet.setHead(list);
      }

      OutputStream outputStream = null;
      ExcelWriter writer = null;
      try {
         outputStream = new FileOutputStream(filePath);
         writer = EasyExcelFactory.getWriter(outputStream);
         writer.write1(data,sheet);
      } catch (FileNotFoundException e) {
    	  System.out.println("�Ҳ����ļ����ļ�·������, �ļ���{}");
      }finally {
         try {
            if(writer != null){
               writer.finish();
            }

            if(outputStream != null){
               outputStream.close();
            }

         } catch (IOException e) {
        	 System.out.println("excel�ļ�����ʧ��, ʧ��ԭ��{}");
         }
      }

   }

   /**
    * ����excle
    * @param filePath ����·��, �磺/home/chenmingjian/Downloads/aaa.xlsx
    * @param data ����Դ
    */
   public static void writeWithTemplate(String filePath, List<? extends BaseRowModel> data){
      writeWithTemplateAndSheet(filePath,data,null);
   }

   /**
    * ����excle
    * @param filePath ����·��, �磺/home/chenmingjian/Downloads/aaa.xlsx
    * @param data ����Դ
    * @param sheet excleҳ����ʽ
    */
   public static void writeWithTemplateAndSheet(String filePath, List<? extends BaseRowModel> data, Sheet sheet){
      if(CollectionUtils.isEmpty(data)){
         return;
      }

      sheet = (sheet != null) ? sheet : initSheet;
      sheet.setClazz(data.get(0).getClass());

      OutputStream outputStream = null;
      ExcelWriter writer = null;
      try {
         outputStream = new FileOutputStream(filePath);
         writer = EasyExcelFactory.getWriter(outputStream);
         writer.write(data,sheet);
      } catch (FileNotFoundException e) {
    	  System.out.println("�Ҳ����ļ����ļ�·������, �ļ���{}");
      }finally {
         try {
            if(writer != null){
               writer.finish();
            }

            if(outputStream != null){
               outputStream.close();
            }
         } catch (IOException e) {
        	 System.out.println("excel�ļ�����ʧ��, ʧ��ԭ��{}");
         }
      }

   }

   /**
    * ���ɶ�Sheet��excle
    * @param filePath ����·��, �磺/home/chenmingjian/Downloads/aaa.xlsx
    * @param multipleSheelPropetys
    */
   public static void writeWithMultipleSheel(String filePath,List<MultipleSheelPropety> multipleSheelPropetys){
      if(CollectionUtils.isEmpty(multipleSheelPropetys)){
         return;
      }

      OutputStream outputStream = null;
      ExcelWriter writer = null;
      try {
         outputStream = new FileOutputStream(filePath);
         writer = EasyExcelFactory.getWriter(outputStream);
         for (MultipleSheelPropety multipleSheelPropety : multipleSheelPropetys) {
            Sheet sheet = multipleSheelPropety.getSheet() != null ? multipleSheelPropety.getSheet() : initSheet;
            if(!CollectionUtils.isEmpty(multipleSheelPropety.getData())){
               sheet.setClazz(multipleSheelPropety.getData().get(0).getClass());
            }
            writer.write(multipleSheelPropety.getData(), sheet);
         }

      } catch (FileNotFoundException e) {
    	  System.out.println("�Ҳ����ļ����ļ�·������, �ļ���{}" +  filePath);
      }finally {
         try {
            if(writer != null){
               writer.finish();
            }

            if(outputStream != null){
               outputStream.close();
            }
         } catch (IOException e) {
        	 System.out.println("excel�ļ�����ʧ��, ʧ��ԭ��{}" + e.getMessage());
         }
      }

   }


   /*********************�����ڲ��࿪ʼ��������ȡ��ȥ******************************/

   public static class MultipleSheelPropety{

      private List<? extends BaseRowModel> data;

      private Sheet sheet;

	public List<? extends BaseRowModel> getData() {
		return data;
	}

	public void setData(List<? extends BaseRowModel> data) {
		this.data = data;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}
      
      
   }

   /**
    * ������������
    * ÿ����һ�л�ص�invoke()������
    * ����excel����������ִ��doAfterAllAnalysed()����
    *
    * @author: chenmingjian
    * @date: 19-4-3 14:11
    */
   public static class ExcelListener extends AnalysisEventListener {

      private List<Object> datas = new ArrayList<>();

      /**
       * ���н���
       * object : ��ǰ�е�����
       */
      @Override
      public void invoke(Object object, AnalysisContext context) {
         //��ǰ��
         // context.getCurrentRowNum()
         if (object != null) {
            datas.add(object);
         }
      }


      /**
       * �������������ݺ����ø÷���
       */
      @Override
      public void doAfterAllAnalysed(AnalysisContext context) {
         //�����������ٲ��õ���Դ
      }


	public List<Object> getDatas() {
		return datas;
	}


	public void setDatas(List<Object> datas) {
		this.datas = datas;
	}
      
      
      

   }

   /************************�����ڲ��������������ȡ��ȥ***************************/

}

