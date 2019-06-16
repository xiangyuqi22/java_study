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
public abstract class AudioPlayer implements MediaPlayer {

	@Override
	public void play(String mediaType, String fileName) {
		if("mp3".equalsIgnoreCase(mediaType)) {
			playMp3(fileName);
		}else if("vlc".equalsIgnoreCase(mediaType)) {
			playVlc(fileName);
		}else {
			System.out.println("���Ÿ�ʽ����ȷ");
		}
	}
	
	protected abstract void playMp3(String fileName);

	protected abstract void playVlc(String fileName);
	
}
