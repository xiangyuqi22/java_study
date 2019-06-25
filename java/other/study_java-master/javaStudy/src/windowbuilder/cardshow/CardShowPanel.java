package windowbuilder.cardshow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;

import windowbuilder.page.IPagination;
import windowbuilder.page.PaginationJpanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��24��
 * @author xiangning
 * @since JDK1.8
 */
public class CardShowPanel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardShowPanel window = new CardShowPanel();
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
	public CardShowPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		
		
		JPanel jpanel = new JPanel(new BorderLayout());
		frame.setContentPane(jpanel);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4, 5, 5, 5));
		jpanel.add(center,BorderLayout.CENTER);
		
		for (int i = 0; i < 20; i++) {
			MyPanel panel = new MyPanel();
			center.add(panel);
		}
		
		{
			PaginationJpanel bottomPanel = new PaginationJpanel(5,10,10,new IPagination() {
				
				@Override
				public void update(JPanel panel,int rows, int currentPage) {
					System.out.println("��������");
					PaginationJpanel page = (PaginationJpanel)panel;
					page.afterUpdate(121);
					System.out.println("��ǰ��������:" + rows);
					System.out.println("��ǰҳΪ:" + currentPage);
				}
			});
			jpanel.add(bottomPanel,BorderLayout.SOUTH);
			
		}
		
		
	}

}

class MyPanel extends JPanel{
	public MyPanel(){
		this.setPreferredSize(new Dimension(300, 200));
		this.setLayout(new BorderLayout());
		this.setBackground(Color.red);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				MyPanel.this.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				MyPanel.this.setBackground(Color.red);
			}
		});
	}
}


