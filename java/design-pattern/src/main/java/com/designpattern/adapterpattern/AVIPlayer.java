package com.designpattern.adapterpattern;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月25日
 * @author xiangning
 * @since JDK1.8
 */
public class AVIPlayer extends VedioPlay {

	@Override
	public void playMP4(String fileName) {
		
	}

	@Override
	public void playAVI(String fileName) {
		System.out.println("执行AVI的播放：" + fileName);
	}

}
