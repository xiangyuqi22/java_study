package windowbuilder.jbutton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 *  
 * @version 1.0 2018年12月5日
 * @author xiangning
 * @since JDK1.8
 */
public class JbuttonFirst {

	private JFrame frame;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JbuttonFirst window = new JbuttonFirst();
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
	public JbuttonFirst() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("失去焦点");
			}
		});
		button.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		button.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
			}
		});
		buttonGroup.add(button);
		button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//button.setText(textField.getText());
				//textArea.setText(textField.getText());
				System.out.println(textArea.getText());
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("鼠标松开");
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(Color.RED);
		frame.getContentPane().add(button, BorderLayout.SOUTH);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setTabSize(80);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
	}
	
	 /**
		 * 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
		 */
		 private static void InitGlobalFont(Font font) {
			  FontUIResource fontRes = new FontUIResource(font);
			  for (Enumeration<Object> keys = UIManager.getDefaults().keys();
			  keys.hasMoreElements(); ) {
			  Object key = keys.nextElement();
			  Object value = UIManager.get(key);
			  if (value instanceof FontUIResource) {
			  UIManager.put(key, fontRes);
			  }
			  }
		}

	public JFrame getFrame() {
		return frame;
	}  
		 
		 

}
