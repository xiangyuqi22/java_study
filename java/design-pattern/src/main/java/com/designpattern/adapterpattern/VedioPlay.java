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
public abstract class VedioPlay implements MediaPlayer{
	

	@Override
	public void play(String mediaType, String fileName) {
		if("mp4".equalsIgnoreCase(mediaType)) {
			playMP4(fileName);
		}else if("avi".equalsIgnoreCase(mediaType)) {
			playAVI(fileName);
		}else {
			System.out.println("格式错误");
		}
	}
	
	public abstract void playMP4(String fileName);
	
	public abstract void playAVI(String fileName);
	
}
