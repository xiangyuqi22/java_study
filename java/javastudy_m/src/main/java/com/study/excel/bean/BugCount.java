package com.study.excel.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * <PRE>
 * ȱ�ݻ���ģ��
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��14��
 * @author xiangning
 * @since JDK1.8
 */
public class BugCount extends BaseRowModel {

	/**
	 * ���
	 */
	@ExcelProperty(value = {"���","���"} ,index = 0)
	private Integer id;

	/**
	 * �����豸
	 */
	@ExcelProperty(value = {"�����豸","�����豸"} ,index = 1)
	private String testDevice;

	/**
	 * ����bug
	 */
	@ExcelProperty(value = {"BUG����","BUG����"} ,index = 2)
	private Integer allBug;

	/**
	 * ���޸�
	 */
	@ExcelProperty(value = {"���޸�BUG","���޸�BUG"} ,index = 3)
	private Integer repairedBug;

	/**
	 * δ�޸�
	 */
	@ExcelProperty(value = {"δ�޸�BUG","δ�޸�BUG"} ,index = 4)
	private Integer unrepairedBug;

	/**
	 * ���� 
	 */
	@ExcelProperty(value = {"δ�޸�BUG�ֲ��������λ������","����"} ,index = 5)
	private Integer deadlyBug;

	/**
	 * ����
	 */
	@ExcelProperty(value = {"δ�޸�BUG�ֲ��������λ������","����"} ,index = 6)
	private Integer seriousBug;

	/**
	 * һ��
	 */
	@ExcelProperty(value = {"δ�޸�BUG�ֲ��������λ������","һ��"} ,index = 7)
	private Integer commonlyBug;

	/**
	 * ����
	 */
	@ExcelProperty(value = {"δ�޸�BUG�ֲ��������λ������","����"} ,index = 8)
	private Integer warnBug;

	/**
	 * �����Ż�
	 */
	@ExcelProperty(value = {"δ�޸�BUG�ֲ��������λ������","�����Ż�"} ,index = 9)
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
