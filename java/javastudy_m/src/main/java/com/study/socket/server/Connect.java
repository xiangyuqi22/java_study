package com.study.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.study.utils.GlobalUtils;

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
public class Connect extends Thread {
	private String context  = "��֪���Ǹ��˲�������,���һ����ڵ�,�����ſ�����������ҹ,��������ڲ��ϵı仯,�Ҳŷ�������������ô��,ȴ����û�п������Ƭ���";

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
