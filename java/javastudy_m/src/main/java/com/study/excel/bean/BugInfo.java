package com.study.excel.bean;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <PRE>
 * 缺陷详情模型
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月14日
 * @author xiangning
 * @since JDK1.8
 */
@Data
@Getter
@Setter
public class BugInfo  extends BaseRowModel{
	
	@ExcelProperty(value = "Bug ID\r\n" + 
			"(缺陷编号)" ,index = 0)
	private Integer bugId;
	
	@ExcelProperty(value = " Subject\r\n" + 
			"(功能模块)" ,index = 1)
	private String subject;
	
	@ExcelProperty(value = "Case_Name\r\n" + 
			"(用例名称)" ,index = 2)
	private String caseName;
	
	@ExcelProperty(value = "Bug Description\r\n" + 
			"(缺陷描述)   " ,index = 3)
	private String bugDescription;
	
	@ExcelProperty(value = "Severity Level\r\n" + 
			"(严重等级)   " ,index = 4)
	private String severityLevel;
	
	@ExcelProperty(value = "Status\r\n" + 
			"状态" ,index = 5)
	private String status;
	
	@ExcelProperty(value = "instructions\r\n" + 
			"备注说明" ,index = 6)
	private String instructions;
	
	@ExcelProperty(value = "picture\r\n" + 
			"截图" ,index = 7)
	private String picture;
	
	@ExcelProperty(value = "software Version\r\n" + 
			"软件版本" ,index = 8)
	private String softwareVersion;

	@ExcelProperty(value = "Test Date\r\n" + 
			"测试时间" ,index = 9 , format = "yyyy/MM/dd")
	private Date testDate;
	
}
