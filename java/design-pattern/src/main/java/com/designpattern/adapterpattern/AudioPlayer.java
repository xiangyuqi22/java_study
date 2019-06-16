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
public abstract class AudioPlayer implements MediaPlayer {

	@Override
	public void play(String mediaType, String fileName) {
		if("mp3".equalsIgnoreCase(mediaType)) {
			playMp3(fileName);
		}else if("vlc".equalsIgnoreCase(mediaType)) {
			playVlc(fileName);
		}else {
			System.out.println("播放格式不正确");
		}
	}
	
	protected abstract void playMp3(String fileName);

	protected abstract void playVlc(String fileName);
	
}
