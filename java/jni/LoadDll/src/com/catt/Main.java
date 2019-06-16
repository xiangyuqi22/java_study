package com.catt;

import javax.swing.JOptionPane;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：LoadDll</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年2月15日
 * @author xiangning
 * @since JDK1.8
 */
public class Main {
	
	public static void main(String[] args) {
		int showConfirmDialog = JOptionPane.showConfirmDialog(null, "是否加载指定路径的dll文件");
		
		try {
			if( showConfirmDialog == 0) {
				String path = JOptionPane.showInputDialog("请输入DLL库路径");
				System.load(path);
			}else {
				System.loadLibrary("LibXIStream_JAVA");
			}
			JOptionPane.showMessageDialog(null, "加载成功");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "加载失败");
		}
		
	}
}
