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
public class AVIPlayer extends VedioPlay {

	@Override
	public void playMP4(String fileName) {
		
	}

	@Override
	public void playAVI(String fileName) {
		System.out.println("ִ��AVI�Ĳ��ţ�" + fileName);
	}

}
