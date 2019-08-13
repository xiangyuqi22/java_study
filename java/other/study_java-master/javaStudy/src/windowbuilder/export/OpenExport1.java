package windowbuilder.export;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年7月22日
 * @author xiangning
 * @since JDK1.8
 */
public class OpenExport1 {
	
	public static void main(String[] args) {
		if (java.awt.Desktop.isDesktopSupported()) {
			try {
				// 创建一个URI实例
				java.net.URI uri = java.net.URI.create("http://www.taobao.com");
				// 获取当前系统桌面扩展
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				// 判断系统桌面是否支持要执行的功能
				if (dp.isSupported(java.awt.Desktop.Action.BROWSE))  {
					// 获取系统默认浏览器打开链接
					dp.browse(uri);
				}
 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
