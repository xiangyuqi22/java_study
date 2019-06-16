package com.study.excel.bean;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <PRE>
 * ȱ������ģ��
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��14��
 * @author xiangning
 * @since JDK1.8
 */
@Data
@Getter
@Setter
public class BugInfo  extends BaseRowModel{
	
	@ExcelProperty(value = "Bug ID\r\n" + 
			"(ȱ�ݱ��)" ,index = 0)
	private Integer bugId;
	
	@ExcelProperty(value = " Subject\r\n" + 
			"(����ģ��)" ,index = 1)
	private String subject;
	
	@ExcelProperty(value = "Case_Name\r\n" + 
			"(��������)" ,index = 2)
	private String caseName;
	
	@ExcelProperty(value = "Bug Description\r\n" + 
			"(ȱ������)   " ,index = 3)
	private String bugDescription;
	
	@ExcelProperty(value = "Severity Level\r\n" + 
			"(���صȼ�)   " ,index = 4)
	private String severityLevel;
	
	@ExcelProperty(value = "Status\r\n" + 
			"״̬" ,index = 5)
	private String status;
	
	@ExcelProperty(value = "instructions\r\n" + 
			"��ע˵��" ,index = 6)
	private String instructions;
	
	@ExcelProperty(value = "picture\r\n" + 
			"��ͼ" ,index = 7)
	private String picture;
	
	@ExcelProperty(value = "software Version\r\n" + 
			"����汾" ,index = 8)
	private String softwareVersion;

	@ExcelProperty(value = "Test Date\r\n" + 
			"����ʱ��" ,index = 9 , format = "yyyy/MM/dd")
	private Date testDate;
	
}
