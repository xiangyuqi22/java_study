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
public class Mp4Player extends VedioPlay {

	@Override
	public void playMP4(String fileName) {
		System.out.println("����MP4�ļ���" + fileName);
	}

	@Override
	public void playAVI(String fileName) {
	}
}
