package windowbuilder.checkboxlist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��28��
 * @author xiangning
 * @since JDK1.8
 */
public class main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label3 = new JLabel("Media Outlets:");
        Object[] value = new String[]{ "Selected All","Al-Jazeera" , "BBC News" ,"Daily Mail" ,"Fox News","New York Daily News", "New York Times","the Guardian","Wall Street Journal"};  
        Object[] defaultValue = new String[]{ "Selected All" }; 
        MultiComboBox mulit = new MultiComboBox(value, defaultValue);
        frame.setContentPane(mulit);

	}

}
