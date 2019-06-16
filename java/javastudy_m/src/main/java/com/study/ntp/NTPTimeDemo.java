package com.study.ntp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.commons.net.ntp.TimeStamp;


/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��2��21��
 * @author xiangning
 * @since JDK1.8
 */
public class NTPTimeDemo {
	public static void main(String[] args) {
	    try {
			System.out.println(getNTPTime(50, "yyyy-MM-dd hh:mm:ss"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("�쳣");
		}
	}
	
	public static String getNTPTime(int count , String format) throws UnknownHostException {
		String time = null;
		try {
	        NTPUDPClient timeClient = new NTPUDPClient();
	        String timeServerUrl = "202.112.10.60";
	        InetAddress timeServerAddress = InetAddress.getByName(timeServerUrl);
	        System.out.println("timeServerAddress = " + timeServerAddress);
	        timeClient.setDefaultTimeout(1000);
	        TimeInfo timeInfo = timeClient.getTime(timeServerAddress,123);
	        TimeStamp timeStamp = timeInfo.getMessage().getTransmitTimeStamp();
	        DateFormat dateFormat = new SimpleDateFormat(format);
	        return dateFormat.format(timeStamp.getDate());
	    } catch (UnknownHostException e) {
	        System.out.println("��������ַ�쳣");
	        throw e;
	    } catch (IOException e) {
	        System.out.println("��ȡ�쳣");
	        //e.printStackTrace();
	    }
		if(count <= 0) {
			return null;
		}
		if(time == null) {
			return getNTPTime(--count , format);
		}
		return null;
	}
	
	
	
}
