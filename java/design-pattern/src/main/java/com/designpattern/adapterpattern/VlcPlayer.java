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
public class VlcPlayer extends AudioPlayer {

	@Override
	protected void playMp3(String fileName) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void playVlc(String fileName) {
		System.out.println("����VLC�ļ���" + fileName);
	}

}
