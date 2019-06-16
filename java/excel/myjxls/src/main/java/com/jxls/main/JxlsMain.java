package com.jxls.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jxls.bean.BugLevel;
import com.jxls.bean.Employee;
import com.jxls.utils.JxlsUtils;

/**
 * Object collection output demo
 * 
 * @author Leonid Vysochyn
 */
public class JxlsMain {
	static Logger logger = LoggerFactory.getLogger(JxlsMain.class);

	public static void main(String[] args) throws ParseException, IOException {
		logger.info("Running Object Collection demo");
		demo1();
	}

	private static void demo1() {
		OutputStream os = null;
		try {
			System.out.println("开始创建对象");
			long start = System.currentTimeMillis();
			List<Employee> employees = generateSampleEmployeeData();
			System.out.println("耗时:" + (System.currentTimeMillis() - start) / (double)1000 + "秒");
			System.out.println("对象生成完毕");
			os = new FileOutputStream("target/object_collection_output1.xlsx");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("employees", employees);
			BugLevel bugLevel = new BugLevel(21,23,54,54,99);
			model.put("bugLevel", bugLevel);
			
			model.put("nowdate", new Date());
			System.out.println("开始处理报表");
			start = System.currentTimeMillis();
			JxlsUtils.exportExcel("mytemplate.xlsx", os, model);
			System.out.println("报表处理完毕");
			System.out.println("耗时:" + (System.currentTimeMillis() - start) / (double)1000 + "秒");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				os.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static List<Employee> generateSampleEmployeeData() throws ParseException {
		List<Employee> employees = new ArrayList<Employee>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd", Locale.US);
		for (int i = 0; i < 50000; i++) {
			employees.add(new Employee("Elsa", dateFormat.parse("1970-Jul-10"), 1200, 0.15));
			employees.add(new Employee("Oleg", dateFormat.parse("1973-Apr-30"), 2300, 0.25));
			employees.add(new Employee("Neil", dateFormat.parse("1975-Oct-05"), 2500, 0.00));
			employees.add(new Employee("Maria", dateFormat.parse("1978-Jan-07"), 1700, 0.15));
			employees.add(new Employee("John", dateFormat.parse("1969-May-30"), 2800, 0.20));
		}
		return employees;
	}
}
