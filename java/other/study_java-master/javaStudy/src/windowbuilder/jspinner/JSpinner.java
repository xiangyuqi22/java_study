package windowbuilder.jspinner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpinnerNumberModel;

import javafx.scene.control.Spinner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��6��
 * @author xiangning
 * @since JDK1.8
 */
public class JSpinner {

	private JFrame frame;
	private javax.swing.JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSpinner window = new JSpinner();
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
	public JSpinner() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		spinner = new javax.swing.JSpinner();
		spinner.setAlignmentY(15.0f);
		spinner.setToolTipText("99999999999");
		spinner.setForeground(Color.RED);
		spinner.setBackground(Color.RED);
		spinner.setModel(new SpinnerNumberModel(10, 5, 20, 5));
		frame.getContentPane().add(spinner, BorderLayout.NORTH);
	}

}
