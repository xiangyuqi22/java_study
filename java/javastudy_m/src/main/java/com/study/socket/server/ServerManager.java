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

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

import com.study.utils.GlobalUtils;

public class ServerManager {
	
	private static ServerManager serverManager = new ServerManager();
	
	public static ServerManager getSM() {
		return serverManager;
	}
	
	
	private Vector<Socket> vector = new Vector<Socket>();
	
	public void add(Socket socket) {
		vector.add(socket);
	}
	
	
	public void write(Socket socket , String context) {
		
		vector.forEach(s -> {
			if(!s.equals(socket)) {
				out(s, context);
			}
		} );

	}
	
	private void out(Socket socket , String str) {
		OutputStream outputStream = null;
		PrintWriter pw = null;
		BufferedWriter bw = null;
		try {
			outputStream = socket.getOutputStream();
			pw = new PrintWriter(outputStream);
			bw =  new BufferedWriter(pw);
			bw.write(str + "\n");
			bw.flush();
		} catch (IOException e) {
			System.out.println("信息输出失败");
		}finally {
//			GlobalUtils.closeStream(outputStream,pw,bw);
		}
	}
	
	

}
