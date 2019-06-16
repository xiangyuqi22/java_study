package windowbuilder.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年3月11日
 * @author xiangning
 * @since JDK1.8
 */
public class LogInfo extends JDialog {
	private final JLabel scriptName = new JLabel("\u811A\u672C\u540D\u79F0\u663E\u793A\u533A\u57DF"  , JLabel.CENTER);
	private final JTree tree = new JTree();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LogInfo dialog = new LogInfo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LogInfo() {
		setBounds(100, 100, 1006, 651);
		getContentPane().setLayout(new BorderLayout());
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(new Rectangle(0, 0, 300, 0));
			getContentPane().add(scrollPane, BorderLayout.WEST);
		}
		getContentPane().add(scriptName, BorderLayout.NORTH);
	}

}
