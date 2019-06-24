package com.study.socket.server;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.io.output.WriterOutputStream;

import com.study.utils.GlobalUtils;

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
public class ConnectServer extends Thread{
	
	
	private ServerSocket serverSocket;

	public ConnectServer() {
		try {
			serverSocket = new ServerSocket(1989);
			System.out.println("成功启动服务器");
		} catch (IOException e) {
			System.out.println("创建socket失败");
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				InetAddress inetAddress = socket.getInetAddress();
				System.out.println("来源地址:" + inetAddress);
				System.out.println("服务器连接成功");
				new Connect(socket).start();
			} catch (IOException e) {
				System.out.println("创建连接失败");
			}
		}
	}
	
	public void out() {
		
	}
	
	

}
