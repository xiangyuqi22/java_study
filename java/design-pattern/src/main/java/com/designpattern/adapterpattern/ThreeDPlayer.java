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
public class ThreeDPlayer implements MediaPlayer {

	@Override
	public void play(String mediaType, String fileName) {
		System.out.println("����3D�ļ��� " + fileName);
	}

}
