package other.basic.java.utils;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import other.basic.util.StringUtil;

/**
 * <PRE>
 * ��ʾ��Ϣ
 * </PRE>
 *
 * ��Ŀ���ƣ�stbrecorder</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��12��
 * @author xiangning
 * @since JDK1.8
 */
public class ShowUtils {
	
	private static final String NEWLINE = "\n";

	/**
	 * ��Ϣ��ʾ
	 * 
	 * @param message
	 *            ��Ϣ����
	 */
	public static void message(String message) {
		message(null, message);
	}
	/**
	 * message:(��Ϣ��ʾ)
	 * @author zhongjie
	 *
	 * @param parentComponent ��������
	 * @param message ��Ϣ����
	 */
	public static void message(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message);
	}

	

	
	

	/**
	 * ������Ϣ��ʾ
	 * 
	 * @param message
	 *            ��Ϣ����
	 */
	public static void warningMessage(String message) {
		warningMessage(null, message);
	}
	
	/**
	 * warningMessage:(������Ϣ��ʾ)
	 * @author zhongjie
	 *
	 * @param parentComponent ��������
	 * 					
	 * @param message ��Ϣ����
	 */
	public static void warningMessage(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message, "����",
				JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * ������Ϣ��ʾ
	 * 
	 * @param message
	 *            ��Ϣ����
	 */
	public static void errorMessage(String message) {
		errorMessage(null, message);
	}
	/**
	 * errorMessage:(������Ϣ��ʾ)
	 * @author zhongjie
	 *
	 * @param parentComponent ��������
	 * @param message ��Ϣ����
	 */
	public static void errorMessage(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message, "����",
				JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * �Զ������Ϣ��ʾ
	 * 
	 * @param title
	 *            ����
	 * @param message
	 *            ��Ϣ����
	 */
	public static void plainMessage(String title, String message) {
		plainMessage(null, message, title);
	}
	
	/**
	 * plainMessage:(�Զ������Ϣ��ʾ)
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
	 * ����ѡ���ܵ���ʾ
	 * 
	 * @param title
	 *            ����
	 * @param message
	 *            ��Ϣ����
	 * @return ��/�� 0/1
	 */
	public static boolean selectMessage(String message, String title) {
		return selectMessage(null, title, message);
	}
	
	/**
	 * selectMessage:(����ѡ���ܵ���ʾ)
	 * @author zhongjie
	 *
	 * @param parentComponent ��������
	 * @param title ����
	 * @param message ��Ϣ����
	 * @return ��/�� 0/1
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
	 * inputDialog:(�õ�������Ϣ)
	 * @author xiangning
	 *
	 * @param parentComponent
	 * @param message δ���룬�õ�null
	 * @return
	 */
	public static String inputDialog(Component parentComponent , String message){
		return JOptionPane.showInputDialog(parentComponent, message);
	}
	

	
	/**
	 * inpufDialog:(���г�ʼֵ��������ʾ)
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
	 * writeContentToTextArea:(������д�뵽�ı�����)
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
	 * moveBottomPosition:(�ƶ��ı�������ײ�)
	 * @author xiangning
	 *
	 * @param mDataView
	 */
	private static void moveBottomPosition(JTextArea mDataView) {
		mDataView.setCaretPosition(mDataView.getText().length());
		mDataView.moveCaretPosition(mDataView.getText().length());
	}
	
	


	
}
