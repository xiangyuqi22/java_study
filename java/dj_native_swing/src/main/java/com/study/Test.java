package com.study;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.WebBrowserObject;
import chrriis.dj.nativeswing.swtimpl.WebBrowserObject.ObjectHTMLConfiguration;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class Test extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel webBrowserPanel;

	private JWebBrowser webBrowser;

	private String url;

	public Test(String url) {
		super(new BorderLayout());
		this.url = url;
		webBrowserPanel = new JPanel(new BorderLayout());
		webBrowser = new JWebBrowser();
//		webBrowser.navigate(url);
		webBrowser.navigate("E:\\eclipse\\workspaces\\STP\\STP_interface\\stbrecorder\\src\\main\\resource\\config\\html\\index.html");
		webBrowser.setButtonBarVisible(true);
		webBrowser.setMenuBarVisible(true);
		webBrowser.setBarsVisible(true);
		webBrowser.setStatusBarVisible(true);
		webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
		add(webBrowserPanel, BorderLayout.CENTER);
		webBrowser.executeJavascript("alert('haha')"); //执行Js代码
//		webBrowser.setHTMLContent("<html><body>html111</body></html>");
		
//		WebBrowserObject webBrowserObject = new WebBrowserObject(webBrowser) {
//			
//			@Override
//			protected ObjectHTMLConfiguration getObjectHtmlConfiguration() {
//				ObjectHTMLConfiguration conf = new ObjectHTMLConfiguration();
//				conf.setWindowsParamName("这是自己创建的");
//				return conf;
//			}
//		};
//		
//		System.out.println(webBrowserObject.getLoadedResource());
		
		
		
	}

	public static void main(String[] args) {
		final String url = "http://www.baidu.com";
		final String title = "DJ NativeSwiting Test";
		UIUtils.setPreferredLookAndFeel();
		NativeInterface.open();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame(title);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(new Test(url), BorderLayout.CENTER);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
			}
		});
//		NativeInterface.runEventPump();
	}

}
