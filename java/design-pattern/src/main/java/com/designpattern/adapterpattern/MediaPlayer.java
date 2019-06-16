package com.designpattern.adapterpattern;
/**
 * <PRE>
 * 播放文件接口
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月25日
 * @author xiangning
 * @since JDK1.8
 */
public interface MediaPlayer {
	
	public void play(String mediaType,String fileName);
	
}
