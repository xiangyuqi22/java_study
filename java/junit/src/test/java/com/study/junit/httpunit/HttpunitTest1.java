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
 * 添加类描述
 * </PRE>
 *
 * 项目名称：junit_study</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年3月3日
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
		//等同于获取浏览器对象
		WebConversation webConversation = new WebConversation();
		try {
			String indexPage = "http://localhost:8080/junit_study/index.jsp";
			String listPage = "http://localhost:8080/junit_study/list.jsp";
			//得到响应信息
			WebResponse response = webConversation.getResponse(indexPage);
			//获取带有《列表》页的关键字链接
			WebLink link = response.getLinkWith("列表页");
			//点击链接，发送请求
			WebRequest webRequest = link.getRequest();
			String expectedURL = listPage;
			//验证点击链接后的地址是否正确
			assertEquals(expectedURL, webRequest.getURL().toString());
			//获取响应页面-列表页
			WebResponse response2 = webConversation.getResponse(webRequest);
			//在列表页 点击 第一个链接 
			WebLink link2 = response2.getLinks()[0];
			//得到首页的请求
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
		 * 添加cookie
		 */
		webConversation.putCookie("name", "yuqi");
		
//		System.out.println("webConversation.getCookieValue(\"name\") = " + webConversation.getCookieValue("name"));
		
//		System.out.println("webConversation.get_readTimeout() = " + webConversation.get_readTimeout());
		
		try {
			WebResponse response = webConversation.getResponse(formPage);
			//获取第一个form表单
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
				fail("没有从表单中获取username");
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
