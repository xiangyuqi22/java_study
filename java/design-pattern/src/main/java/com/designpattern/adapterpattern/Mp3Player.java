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
public class Mp3Player extends AudioPlayer {

	@Override
	protected void playMp3(String fileName) {
		System.out.println("����MP3�ļ���" + fileName);
	}

	@Override
	protected void playVlc(String fileName) {
		// TODO Auto-generated method stub

	}

}
