package com.study.socket.server;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��23��
 * @author xiangning
 * @since JDK1.8
 */
public class SocketServer {
	
	public static void main(String[] args) {
		ConnectServer connectServer = new ConnectServer();
		connectServer.start();
	}

}
