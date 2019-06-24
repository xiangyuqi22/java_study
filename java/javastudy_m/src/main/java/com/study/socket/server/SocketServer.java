package com.study.socket.server;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月23日
 * @author xiangning
 * @since JDK1.8
 */
public class SocketServer {
	
	public static void main(String[] args) {
		ConnectServer connectServer = new ConnectServer();
		connectServer.start();
	}

}
