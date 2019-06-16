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
public abstract class VedioPlay implements MediaPlayer{
	

	@Override
	public void play(String mediaType, String fileName) {
		if("mp4".equalsIgnoreCase(mediaType)) {
			playMP4(fileName);
		}else if("avi".equalsIgnoreCase(mediaType)) {
			playAVI(fileName);
		}else {
			System.out.println("��ʽ����");
		}
	}
	
	public abstract void playMP4(String fileName);
	
	public abstract void playAVI(String fileName);
	
}
