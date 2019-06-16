package windowbuilder.dialog;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JTextField;

import windowbuilder.jbutton.JbuttonFirst;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月15日
 * @author xiangning
 * @since JDK1.8
 */
public class DialogFirst {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogFirst window = new DialogFirst();
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
	public DialogFirst() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("e.getKeyCode() = " + e.getKeyCode());
			}
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("e.getKeyCode() = " + e.getKeyCode());
			}
		});
		frame.addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
			}
		});
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JDialog d = new JDialog(frame,"好样的");
				//d.setUndecorated(true);
				//d.setBackground(new Color(0, 0, 0,0f));
				//d.setOpacity(0f);
				
				JLabel j = new JLabel("" + System.currentTimeMillis());
				d.getContentPane().add(new JbuttonFirst().getFrame().getContentPane());
				d.setSize(200, 200);
				d.repaint(1000, 0, 0, 300, 300);
				d.setLocationRelativeTo(frame);
				d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				d.setEnabled(true);
				d.setVisible(true);
				
				
			}
		});
		panel.add(button);
		
		textField = new JTextField();
		textField.setText(" ");
		frame.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		
	}

}
