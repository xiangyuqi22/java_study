package com.study.vlc;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月20日
 * @author xiangning
 * @since JDK1.8
 */
public class Start {
	
	public static void main(String[] args) {
		/*VlcPlayer player = VlcPlayer.getInstance();*/
		VlcPlayerDialog vlcPlayerDialog = VlcPlayerDialog.getInstance();
		vlcPlayerDialog.showFrame();
		vlcPlayerDialog.playerMedia("E:\\eclipse\\workspaces\\STP\\STP_interface\\stbrecorder\\target\\classes\\data\\file\\temp\\1548141601826.mp4");

		//vlcPlayerDialog.playerMedia("F:\\xiangyuqi\\mv\\李茶的姑妈.mp4");
	}
}
