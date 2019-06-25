package windowbuilder.page;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import other.basic.util.StringUtil;
import sun.swing.StringUIClientPropertyKey;
import windowbuilder.jbutton.StbButtonGroup;

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
public class PaginationJpanel extends JPanel {
	
	/**
	 * ��ǰҳ
	 */
	private int currentPage = 1;
	
	/**
	 * �ܹ�����ҳ,���ݸ��º�Ҫ�������
	 */
	private int pageSize;
	
	/**
	 * �ܹ��ж���������,���ݸ��º�Ҫ�������
	 */
	private int count;
	
	/**
	 * ÿҳ������
	 */
	private int rows = 10;
	
	private IPagination pagination;
	
	/**
	 * һ���ж��ٸ���ѡ��ť
	 */
	private int paginationSize = 5;
	
	private List<JButton> buttons = new ArrayList<>();

	/**
	 * ��һҳ,��һҳ��ť
	 */
	private JButton preButton,nextButton;

	private static final String PRE_TEXT="��һҳ",NEXT_TEXT="��һҳ";
	
	public PaginationJpanel(IPagination pagination) {
		this.pagination = pagination;
		init();
	}
	
	public PaginationJpanel(int currentPage, int rows , int paginationSize, IPagination pagination) {
		super();
		this.currentPage = currentPage;
		this.rows = rows;
		this.pagination = pagination;
		this.paginationSize = paginationSize;
		init();
	}
	
	private void init() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		addButton();
		updateData();
	}

	private void addButton() {
		preButton = new JButton(PRE_TEXT);
		this.add(preButton);
		this.addListener(preButton);
		for (int i = 1; i <= paginationSize; i++) {
			JButton jButton = new JButton(i + "");
			buttons.add(jButton);
			this.add(jButton);
			this.addListener(jButton);
		}
		nextButton = new JButton(NEXT_TEXT);
		this.add(nextButton);
		this.addListener(nextButton);
	}

	public void changeButton() {
		preButton.setEnabled(currentPage != 1);
		//��������ѡ������,�����ǰ������5����1,��ô���ɾ��� 6 11 16 21 
		//��Ҫ�޸İ�ť��ֵ
		if(currentPage % paginationSize == 1 && currentPage < pageSize) {
			for (int i = 0; i < buttons.size(); i++) {
				JButton jButton = buttons.get(i);
				jButton.setText((currentPage + i) + "");
			}
		}else if(currentPage % paginationSize == 0 && currentPage < pageSize) {
			int num = currentPage + 1 - paginationSize;
			for (int i = 0; i < buttons.size(); i++) {
				JButton jButton = buttons.get(i);
				jButton.setText((num + i) + "");
			}
		}
		for ( int i = 0 ; i < buttons.size(); i++) {
			JButton jButton = buttons.get(i);
			int page = StringUtil.toInt(jButton.getText());
			jButton.setEnabled(page != currentPage);
			jButton.setVisible(page <= pageSize);
		}
		nextButton.setEnabled(currentPage != pageSize);
	}
	
	
	public void afterUpdate(int count) {
		pageSize = count / rows;
		if(count%rows > 0 ) {
			pageSize++;
		}
		//���ݸ������
		changeButton();
	}
	
	/**
	 * addListener:(��Ӱ�ť�¼�����)
	 * @author xiangning
	 *
	 * @param button
	 */
	public void addListener(JButton button) {
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(button.isEnabled()) {
					//��ť����¼�
					buttonClicked(button);
				}
			}
		};
		button.addMouseListener(mouseAdapter);
	}
	
	/**
	 * buttonClicked:(��ť����¼�)
	 * @author xiangning
	 *
	 */
	private void buttonClicked(JButton button) {
		int current = currentPage;
		String text = button.getText();
		if(PRE_TEXT.equals(text) && currentPage > 1 ) {
			//������������һҳ,ͬʱ��ǰҳ������2������,��ô��������Ҫ��ת��ҳΪ��ǰҳ-1
			current = currentPage - 1;
		}else if(NEXT_TEXT.equals(text) && currentPage < pageSize) {
			current = currentPage + 1;
		}else if (StringUtil.isNum(text)) {
			current = StringUtil.toInt(text);
		}
		if(current <= 0 || current == currentPage) {
			//�����ǰҳС��1  ��������ԭ��һ����,��ô��������
			return;
		}
		currentPage = current;
		updateData();
		
	}
	
	
	private void updateData() {
		pagination.update(this, rows, currentPage);
	}
	
	
}
