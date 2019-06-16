package com.designpattern.adapterpattern;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��25��
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
			throw new NullMediaException("���ɲ����ļ�");
		}
	}
	
	/**
	 * verifyData:(��֤�Ƿ��ܹ�����)
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
