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
public class Adapter extends MediaAdapter{

	@Override
	public void play(String fileName) {
		try {
			super.play(fileName);
		} catch (NullMediaException e) {
			if(fileName.toUpperCase().endsWith(".3D")) {
				mediaPlayer = new ThreeDPlayer();
			}
			if(!super.verifyData(fileName)) {
				throw new NullMediaException("���ɲ����ļ�");
			}
		}
		
	}
	
	

}
