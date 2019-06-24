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
public class ConnectServer extends Thread{
	
	
	private ServerSocket serverSocket;

	public ConnectServer() {
		try {
			serverSocket = new ServerSocket(1989);
			System.out.println("�ɹ�����������");
		} catch (IOException e) {
			System.out.println("����socketʧ��");
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				InetAddress inetAddress = socket.getInetAddress();
				System.out.println("��Դ��ַ:" + inetAddress);
				System.out.println("���������ӳɹ�");
				new Connect(socket).start();
			} catch (IOException e) {
				System.out.println("��������ʧ��");
			}
		}
	}
	
	public void out() {
		
	}
	
	

}
