package com.study.excel.easyexcel.exportexcel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.study.excel.bean.BugCount;
import com.study.excel.bean.BugInfo;
import com.study.utils.GlobalUtils;
import com.study.utils.StringUtil;

/**
 * <PRE>
 * 导出报告
 * 
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月14日
 * @author xiangning
 * @since JDK1.8
 */
public class ExportExcel1 {

	private static List<BugCount> bugCountList1;
	private static List<BugInfo> bugInfoList1;

	public static void main(String[] args) throws IOException {
		read();
		write();
	}

	private static void write() throws FileNotFoundException {
		OutputStream out = null;
		InputStream inputStream = null;
		try {
			out = new FileOutputStream("E:\\data\\excel\\" + StringUtil.getNowTime3() + ".xlsx");
			// inputStream = new FileInputStream("E:\\data\\excel\\xxx机顶盒测试报告模板.xlsx");
			// ExcelWriter writer =
			// EasyExcelFactory.getWriterWithTemp(inputStream,out,ExcelTypeEnum.XLSX,true);
			ExcelWriter writer = EasyExcelFactory.getWriter(out , ExcelTypeEnum.XLSX , true);
			Sheet sheet1 = new Sheet(1, 3, BugCount.class);
			sheet1.setSheetName("汇总");
			Map columnWidth = new HashMap();
			columnWidth.put(0, 1000);
			columnWidth.put(1, 4000);
			columnWidth.put(2, 1000);
			columnWidth.put(3, 1000);
			sheet1.setColumnWidthMap(columnWidth);
			// or 设置自适应宽度
			sheet1.setAutoWidth(Boolean.TRUE);
			writer.write(bugCountList1, sheet1);

			
			
			
			writer.finish();
	        out.close();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			GlobalUtils.closeStream(out, inputStream);
		}

	}

	private static void read() {
		try {
			bugCountList1 = ExportExcelUtils.read(new Sheet(1, 2, BugCount.class),new BugCount());
			bugInfoList1 = ExportExcelUtils.read(new Sheet(2, 2, BugInfo.class),new BugInfo());
//			bugCountList = ExportExcelUtils.simpleReadJavaModelV2007(new Sheet(1, 2, BugCount.class));
//			bugInfoList = ExportExcelUtils.simpleReadJavaModelV2007(new Sheet(2, 2, BugInfo.class));

			System.out.println(bugCountList1);
			System.out.println(bugInfoList1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fileInputStream.close();
		}
	}
}
