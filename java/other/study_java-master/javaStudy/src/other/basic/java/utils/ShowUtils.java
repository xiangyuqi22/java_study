package other.basic.java.utils;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import other.basic.util.StringUtil;

/**
 * <PRE>
 * 提示信息
 * </PRE>
 *
 * 项目名称：stbrecorder</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月12日
 * @author xiangning
 * @since JDK1.8
 */
public class ShowUtils {
	
	private static final String NEWLINE = "\n";

	/**
	 * 消息提示
	 * 
	 * @param message
	 *            消息内容
	 */
	public static void message(String message) {
		message(null, message);
	}
	/**
	 * message:(消息提示)
	 * @author zhongjie
	 *
	 * @param parentComponent 父面板对象
	 * @param message 消息内容
	 */
	public static void message(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message);
	}

	

	
	

	/**
	 * 警告消息提示
	 * 
	 * @param message
	 *            消息内容
	 */
	public static void warningMessage(String message) {
		warningMessage(null, message);
	}
	
	/**
	 * warningMessage:(警告消息提示)
	 * @author zhongjie
	 *
	 * @param parentComponent 父面板对象
	 * 					
	 * @param message 消息内容
	 */
	public static void warningMessage(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message, "警告",
				JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * 错误消息提示
	 * 
	 * @param message
	 *            消息内容
	 */
	public static void errorMessage(String message) {
		errorMessage(null, message);
	}
	/**
	 * errorMessage:(错误消息提示)
	 * @author zhongjie
	 *
	 * @param parentComponent 父面板对象
	 * @param message 消息内容
	 */
	public static void errorMessage(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message, "错误",
				JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * 自定义的消息提示
	 * 
	 * @param title
	 *            标题
	 * @param message
	 *            消息内容
	 */
	public static void plainMessage(String title, String message) {
		plainMessage(null, message, title);
	}
	
	/**
	 * plainMessage:(自定义的消息提示)
	 * @author zhongjie
	 *
	 * @param parentComponent
	 * @param title
	 * @param message
	 */
	public static void plainMessage(Component parentComponent, String title, String message) {
		JOptionPane.showMessageDialog(parentComponent, message, title,
				JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * 带有选择功能的提示
	 * 
	 * @param title
	 *            标题
	 * @param message
	 *            消息内容
	 * @return 是/否 0/1
	 */
	public static boolean selectMessage(String message, String title) {
		return selectMessage(null, title, message);
	}
	
	/**
	 * selectMessage:(带有选择功能的提示)
	 * @author zhongjie
	 *
	 * @param parentComponent 父面板对象
	 * @param title 标题
	 * @param message 消息内容
	 * @return 是/否 0/1
	 */
	public static boolean selectMessage(Component parentComponent, String title, String message) {
		int isConfirm = JOptionPane.showConfirmDialog(parentComponent, message, title,
				JOptionPane.YES_NO_OPTION);
		if (0 == isConfirm) {
			return true;
		}
		return false;
	}
	/**
	 * inputDialog:(得到输入信息)
	 * @author xiangning
	 *
	 * @param parentComponent
	 * @param message 未输入，得到null
	 * @return
	 */
	public static String inputDialog(Component parentComponent , String message){
		return JOptionPane.showInputDialog(parentComponent, message);
	}
	

	
	/**
	 * inpufDialog:(带有初始值的输入提示)
	 * @author xiangning
	 *
	 * @param parentComponent
	 * @param message
	 * @param initialSelectionValue
	 * @return
	 */
	public static String inputDialog(Component parentComponent, Object message,
            Object initialSelectionValue) {
		return JOptionPane.showInputDialog(parentComponent, message, initialSelectionValue);
	}
	
	/**
	 * writeContentToTextArea:(将内容写入到文本区域)
	 * @author xiangning
	 *
	 * @param mDataView
	 * @param content
	 */
	public static void writeContentToTextAreaNewLine(JTextArea mDataView,String content) {
		mDataView.append(StringUtil.getNowDate() + " >> " + content + NEWLINE);
		moveBottomPosition(mDataView);
	}
	
	public static void writeContentToTextArea(JTextArea mDataView,String content) {
		mDataView.append(StringUtil.getNowDate() + " >> " + content);
		moveBottomPosition(mDataView);
	}
	
	/**
	 * moveBottomPosition:(移动文本区域到最底部)
	 * @author xiangning
	 *
	 * @param mDataView
	 */
	private static void moveBottomPosition(JTextArea mDataView) {
		mDataView.setCaretPosition(mDataView.getText().length());
		mDataView.moveCaretPosition(mDataView.getText().length());
	}
	
	


	
}
