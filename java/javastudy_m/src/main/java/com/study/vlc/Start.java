package com.study.vlc;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��1��20��
 * @author xiangning
 * @since JDK1.8
 */
public class Start {
	
	public static void main(String[] args) {
		/*VlcPlayer player = VlcPlayer.getInstance();*/
		VlcPlayerDialog vlcPlayerDialog = VlcPlayerDialog.getInstance();
		vlcPlayerDialog.showFrame();
		vlcPlayerDialog.playerMedia("E:\\eclipse\\workspaces\\STP\\STP_interface\\stbrecorder\\target\\classes\\data\\file\\temp\\1548141601826.mp4");

		//vlcPlayerDialog.playerMedia("F:\\xiangyuqi\\mv\\���Ĺ���.mp4");
	}
}
