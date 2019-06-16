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
public class MediaAdapter {
	
	protected MediaPlayer mediaPlayer = null;
	
	public void play(String fileName) {
		String mediaType = null;
		if(fileName.toUpperCase().endsWith(".MP4")) {
			mediaPlayer = new Mp4Player();
		}else if(fileName.toUpperCase().endsWith(".AVI")) {
			mediaPlayer = new AVIPlayer();
		}else if(fileName.toUpperCase().endsWith(".MP3")) {
			mediaPlayer = new Mp3Player();
		}else if(fileName.toUpperCase().endsWith(".VLC")) {
			mediaPlayer = new VlcPlayer();
		}
		if(!verifyData(fileName)) {
			throw new NullMediaException("不可播放文件");
		}
	}
	
	/**
	 * verifyData:(验证是否能够播放)
	 * @author xiangning
	 *
	 * @param fileName
	 * @return
	 */
	protected boolean verifyData(String fileName) {
		if(mediaPlayer != null && fileName!= null && !"".equals(fileName)) {
			String mediaType = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length());
			if(!fileName.equals(mediaType) && fileName.lastIndexOf('.') != 0) {
				mediaPlayer.play(mediaType, fileName);
				return true;
			}
		}
		return false;
	}
}
