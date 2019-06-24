package com.study.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

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
public class Connect extends Thread {
	private String context  = "我知道那个人不会再来,但我还是在等,我在门口坐了两天两夜,看着天空在不断的变化,我才发现来到这里这么久,却从来没有看清楚这片天空";

	private Socket socket;

	private ServerManager sm;

	public Connect(Socket socket) {
		this.socket = socket;
		sm = ServerManager.getSM();
		sm.add(socket);
	}
	
	@Override 
	public void run() {
		// telnet localhost 1989
		InputStream inputStream = null;
		InputStreamReader ims = null;
		BufferedReader br = null;
		try {
			inputStream = socket.getInputStream();
			ims = new InputStreamReader(inputStream);
			br = new BufferedReader(ims);
			String str;
			while((str = br.readLine()) != null) {
				sm.write(socket, str);
			}
		} catch (IOException e) {
			System.out.println("");
		}finally {
//				GlobalUtils.closeStream(inputStream,ims,br);
		}
	}
	


}
