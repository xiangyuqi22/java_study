package com.catt;

import javax.swing.JOptionPane;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�LoadDll</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��2��15��
 * @author xiangning
 * @since JDK1.8
 */
public class Main {
	
	public static void main(String[] args) {
		int showConfirmDialog = JOptionPane.showConfirmDialog(null, "�Ƿ����ָ��·����dll�ļ�");
		
		try {
			if( showConfirmDialog == 0) {
				String path = JOptionPane.showInputDialog("������DLL��·��");
				System.load(path);
			}else {
				System.loadLibrary("LibXIStream_JAVA");
			}
			JOptionPane.showMessageDialog(null, "���سɹ�");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "����ʧ��");
		}
		
	}
}
