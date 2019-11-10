package com.study.httpclient;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��9��27��
 * @author xiangning
 * @since JDK1.8
 */
public class Main {
	
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID&corpsecret=SECRET";
		
		url = "http://qywx.qiweioa.cn/cgi-bin/gettoken?corpid=wlc728fe3880&corpsecret=PCQxIoVaabQ9b5i0Sd3JsNkTpN9gwTYULDDMTFDl66c";
		demo2(url);
	}
	
	private static void demo2(String url) throws ClientProtocolException, IOException {
		String result = Request.Get(url)
	    .execute().returnContent().asString(Charset.forName("utf-8"));
		System.out.println(result);
	}
	
	
	private static void demo1(String url) {
		String result = HttpClientUtils.doGet(url, "utf-8");
		System.out.println(result);
		System.out.println("ʹ��post����");
		url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=wlc728fe3880&corpsecret=PCQxIoVaabQ9b5i0Sd3JsNkTpN9gwTYULDDMTFDl66c";
		result = HttpClientUtils.doPost(url,"", "utf-8");
		System.out.println(result);

	}
	

}
