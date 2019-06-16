package com.study.excel.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * <PRE>
 * 缺陷汇总模型
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月14日
 * @author xiangning
 * @since JDK1.8
 */
public class BugCount extends BaseRowModel {

	/**
	 * 序号
	 */
	@ExcelProperty(value = {"序号","序号"} ,index = 0)
	private Integer id;

	/**
	 * 测试设备
	 */
	@ExcelProperty(value = {"测试设备","测试设备"} ,index = 1)
	private String testDevice;

	/**
	 * 所有bug
	 */
	@ExcelProperty(value = {"BUG汇总","BUG汇总"} ,index = 2)
	private Integer allBug;

	/**
	 * 已修复
	 */
	@ExcelProperty(value = {"已修复BUG","已修复BUG"} ,index = 3)
	private Integer repairedBug;

	/**
	 * 未修复
	 */
	@ExcelProperty(value = {"未修复BUG","未修复BUG"} ,index = 4)
	private Integer unrepairedBug;

	/**
	 * 致命 
	 */
	@ExcelProperty(value = {"未修复BUG分布情况（单位：个）","致命"} ,index = 5)
	private Integer deadlyBug;

	/**
	 * 严重
	 */
	@ExcelProperty(value = {"未修复BUG分布情况（单位：个）","严重"} ,index = 6)
	private Integer seriousBug;

	/**
	 * 一般
	 */
	@ExcelProperty(value = {"未修复BUG分布情况（单位：个）","一般"} ,index = 7)
	private Integer commonlyBug;

	/**
	 * 警告
	 */
	@ExcelProperty(value = {"未修复BUG分布情况（单位：个）","警告"} ,index = 8)
	private Integer warnBug;

	/**
	 * 建议优化
	 */
	@ExcelProperty(value = {"未修复BUG分布情况（单位：个）","建议优化"} ,index = 9)
	private Integer optimization;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTestDevice() {
		return testDevice;
	}

	public void setTestDevice(String testDevice) {
		this.testDevice = testDevice;
	}

	public Integer getAllBug() {
		return allBug;
	}

	public void setAllBug(Integer allBug) {
		this.allBug = allBug;
	}

	public Integer getRepairedBug() {
		return repairedBug;
	}

	public void setRepairedBug(Integer repairedBug) {
		this.repairedBug = repairedBug;
	}

	public Integer getUnrepairedBug() {
		return unrepairedBug;
	}

	public void setUnrepairedBug(Integer unrepairedBug) {
		this.unrepairedBug = unrepairedBug;
	}

	public Integer getDeadlyBug() {
		return deadlyBug;
	}

	public void setDeadlyBug(Integer deadlyBug) {
		this.deadlyBug = deadlyBug;
	}

	public Integer getSeriousBug() {
		return seriousBug;
	}

	public void setSeriousBug(Integer seriousBug) {
		this.seriousBug = seriousBug;
	}

	public Integer getCommonlyBug() {
		return commonlyBug;
	}

	public void setCommonlyBug(Integer commonlyBug) {
		this.commonlyBug = commonlyBug;
	}

	public Integer getWarnBug() {
		return warnBug;
	}

	public void setWarnBug(Integer warnBug) {
		this.warnBug = warnBug;
	}

	public Integer getOptimization() {
		return optimization;
	}

	public void setOptimization(Integer optimization) {
		this.optimization = optimization;
	}

	@Override
	public String toString() {
		return "BugCount [id=" + id + ", testDevice=" + testDevice + ", allBug=" + allBug + ", repairedBug="
				+ repairedBug + ", unrepairedBug=" + unrepairedBug + ", deadlyBug=" + deadlyBug + ", seriousBug="
				+ seriousBug + ", commonlyBug=" + commonlyBug + ", warnBug=" + warnBug + ", optimization="
				+ optimization + "]";
	}

}
