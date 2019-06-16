package com.jxls.bean;

import javax.annotation.Generated;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：myjxls</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月15日
 * @author xiangning
 * @since JDK1.8
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BugLevel {
	
	/**
	 * 致命 
	 */
	private Integer deadlyBug;

	/**
	 * 严重
	 */
	private Integer seriousBug;

	/**
	 * 一般
	 */
	private Integer commonlyBug;

	/**
	 * 警告
	 */
	private Integer warnBug;

	/**
	 * 建议优化
	 */
	private Integer optimization;

}
