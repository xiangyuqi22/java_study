package com.study.junit.httpunit;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.xml.sax.SAXException;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

import junit.textui.TestRunner;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�junit_study</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��3��3��
 * @author xiangning
 * @since JDK1.8
 */
public class HttpunitTest1 {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//��ͬ�ڻ�ȡ���������
		WebConversation webConversation = new WebConversation();
		try {
			String indexPage = "http://localhost:8080/junit_study/index.jsp";
			String listPage = "http://localhost:8080/junit_study/list.jsp";
			//�õ���Ӧ��Ϣ
			WebResponse response = webConversation.getResponse(indexPage);
			//��ȡ���С��б�ҳ�Ĺؼ�������
			WebLink link = response.getLinkWith("�б�ҳ");
			//������ӣ���������
			WebRequest webRequest = link.getRequest();
			String expectedURL = listPage;
			//��֤������Ӻ�ĵ�ַ�Ƿ���ȷ
			assertEquals(expectedURL, webRequest.getURL().toString());
			//��ȡ��Ӧҳ��-�б�ҳ
			WebResponse response2 = webConversation.getResponse(webRequest);
			//���б�ҳ ��� ��һ������ 
			WebLink link2 = response2.getLinks()[0];
			//�õ���ҳ������
			WebRequest webRequest2 = link2.getRequest();
			assertEquals(indexPage, webRequest2.getURL().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(timeout = 500)
	public void formTest() {
		
		String formPage = "http://localhost:8080/junit_study/form.jsp";
		
		WebConversation webConversation = new WebConversation();
		
		webConversation.set_connectTimeout(1000);
		
		/**
		 * ���cookie
		 */
		webConversation.putCookie("name", "yuqi");
		
//		System.out.println("webConversation.getCookieValue(\"name\") = " + webConversation.getCookieValue("name"));
		
//		System.out.println("webConversation.get_readTimeout() = " + webConversation.get_readTimeout());
		
		try {
			WebResponse response = webConversation.getResponse(formPage);
			//��ȡ��һ��form��
			WebForm webForm = response.getForms()[0];
			webForm.setParameter("username", "xiangning");
//			webForm.setAttribute("gender", "boy");
//			webForm.setCheckbox("gender", true);
			webForm.setParameter("fav", "sleep");
			webForm.setParameter("gender", "girl");
			assertEquals("xiangning", webForm.getParameterValue("username"));
			assertEquals("sleep", webForm.getParameterValue("fav"));
			assertEquals("girl", webForm.getParameterValue("gender"));
//			
			
			WebResponse webResponse2 = webForm.submit();
			
			if(webResponse2.getURL().toString().contains("xiangning")) {
				
			}else {
				fail("û�дӱ��л�ȡusername");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Thread() {
            public void run() {
                JUnitCore.runClasses(new Class[] { HttpunitTest1.class });
           }
        }.start();
	}

}
