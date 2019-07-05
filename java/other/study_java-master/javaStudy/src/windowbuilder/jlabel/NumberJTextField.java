package windowbuilder.jlabel;

import java.awt.EventQueue;
import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JTextField;

import other.basic.java.utils.StringUtils2;
import other.basic.util.StringUtil;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月26日
 * @author xiangning
 * @since JDK1.8
 */
public class NumberJTextField {

	private JFrame frame;
	private NumberTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberJTextField window = new NumberJTextField();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NumberJTextField() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 768, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new NumberTextField(100L,100L,new NumberTextField.KeyUpListener() {
			
			@Override
			public void afterKeyUp(String text) {
				System.out.println("鼠标松开时,获取最终值:" + text);
			}
		});
		textField.setText("fdfsdvsdfsd-fsvv43243");
		
		frame.getContentPane().add(textField, BorderLayout.CENTER);
		
//		textField_1 = new JTextField();
//		
//		frame.getContentPane().add(textField_1, BorderLayout.CENTER);
//		textField_1.setColumns(10);
		textField.setColumns(10);
	}

}



class NumberTextField extends JTextField{
	
	private long max;
	private long min;
	private KeyUpListener keyUpListener;
	
	/**
	 * 可输入最大值
	 * @param max
	 */
	public NumberTextField(long max, long min) {
		this.max = max;
		this.min = min;
		addListener();
	}
	
	public NumberTextField(long max, long min,NumberTextField.KeyUpListener keyUpListener) {
		this.max = max;
		this.min = min;
		this.keyUpListener = keyUpListener;
		addListener();
	}
	
	
	private void addListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keyUpListener();
			}
		});
	}
	
	private void keyUpListener() {
		String text = this.getText();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char charAt = text.charAt(i);
			if((charAt <= '9' && charAt >= '0') || (charAt == '-' && i == 0)) {
				sb.append(charAt);
			}
		}
		String t = sb.toString();
		if(t.startsWith("-") && t.length()>1) {
			String substring = t.substring(1);
			int minNum = StringUtil.toInt(substring);
			if(minNum > Math.abs(min)) {
				t = "" + min;
			}
		}else if(!t.startsWith("-") && t.length() >= 1){
			int maxNumber = StringUtil.toInt(t);
			if(maxNumber > max) {
				t = max + "";
			}
		}
		this.setText(t);
		if(keyUpListener != null ) {
			keyUpListener.afterKeyUp(t);
		}
	}
	
	
	/**
	 * <PRE>
	 * 数值输入完成后的回调方法
	 * </PRE>
	 *
	 * 项目名称：javaStudy</BR>
	 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
	 * 
	 * @version 1.0 2019年6月26日
	 * @author xiangning
	 * @since JDK1.8
	 */
	public interface KeyUpListener{
		void afterKeyUp(String text);
	}
	
	
}















