package com.study.excel.jxls;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.excel.bean.Employee;
import com.study.utils.GlobalUtils;
import com.study.utils.JxlsUtils;

/**
 * <PRE>
 =
 注:由于当前依赖与以下三个依赖有冲突,所以另起项目来做
 		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>4.1.0</version>
		</dependency>
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-scratchpad</artifactId>
			<version>4.1.0</version>
		</dependency>
		<dependency>
			<groupId>jfree</groupId>
			<artifactId>jfreechart</artifactId>
			<version>1.0.13</version>
		</dependency>
 
 当前jxls所需要的依赖
 		<dependency>
			<groupId>org.jxls</groupId>
			<artifactId>jxls</artifactId>
			<version>2.3.0</version>
		</dependency>
		<dependency>
			<groupId>org.jxls</groupId>
			<artifactId>jxls-poi</artifactId>
			<version>1.0.9</version>
		</dependency>
		
		
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月15日
 * @author xiangning
 * @since JDK1.8
 */
public class JxlsMain {

	private static Logger logger = LoggerFactory.getLogger(JxlsMain.class);

	public static void main(String[] args) {
//		demo1();
//		demo2();
	}

	private static void demo2() {
		try {
			List<Employee> employees = generateSampleEmployeeData();
			OutputStream os = new FileOutputStream("target/object_collection_output1.xls");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("employees", employees);
			model.put("nowdate", new Date());
			JxlsUtils.exportExcel("object_collection_template.xls", os, model);
			os.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		logger.info("Running Object Collection demo");

	}

	private static void demo1() {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = JxlsMain.class.getResourceAsStream("object_collection_template.xls");
			os = new FileOutputStream("target/object_collection_output22.xls");
			List<Employee> employees = generateSampleEmployeeData();
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("employees", employees);
			model.put("nowdate", new Date());
			JxlsUtils.exportExcel("object_collection_template.xls", os, model);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GlobalUtils.closeStream(is, os);
		}
	}

	public static List<Employee> generateSampleEmployeeData() throws ParseException {
		List<Employee> employees = new ArrayList<Employee>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd", Locale.US);
		employees.add(new Employee("Elsa", dateFormat.parse("1970-Jul-10"), 1500, 0.15));
		employees.add(new Employee("Oleg", dateFormat.parse("1973-Apr-30"), 2300, 0.25));
		employees.add(new Employee("Neil", dateFormat.parse("1975-Oct-05"), 2500, 0.00));
		employees.add(new Employee("Maria", dateFormat.parse("1978-Jan-07"), 1700, 0.15));
		employees.add(new Employee("John", dateFormat.parse("1969-May-30"), 2800, 0.20));
		employees.add(new Employee("Elsa", dateFormat.parse("1970-Jul-10"), 1500, 0.15));
		employees.add(new Employee("Oleg", dateFormat.parse("1973-Apr-30"), 2300, 0.25));
		employees.add(new Employee("Neil", dateFormat.parse("1975-Oct-05"), 2500, 0.00));
		employees.add(new Employee("Maria", dateFormat.parse("1978-Jan-07"), 1700, 0.15));
		return employees;
	}

}
