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
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月24日
 * @author xiangning
 * @since JDK1.8
 */
public class PaginationJpanel extends JPanel {
	
	/**
	 * 当前页
	 */
	private int currentPage = 1;
	
	/**
	 * 总共多少页,数据更新后要计算出来
	 */
	private int pageSize;
	
	/**
	 * 总共有多少数据量,数据更新后要计算出来
	 */
	private int count;
	
	/**
	 * 每页数据量
	 */
	private int rows = 10;
	
	private IPagination pagination;
	
	/**
	 * 一共有多少个可选按钮
	 */
	private int paginationSize = 5;
	
	private List<JButton> buttons = new ArrayList<>();

	/**
	 * 上一页,下一页按钮
	 */
	private JButton preButton,nextButton;

	private static final String PRE_TEXT="上一页",NEXT_TEXT="下一页";
	
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
		//设置数字选择区域,如果当前区域余5等于1,那么它可就是 6 11 16 21 
		//需要修改按钮数值
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
		//数据更新完成
		changeButton();
	}
	
	/**
	 * addListener:(添加按钮事件监听)
	 * @author xiangning
	 *
	 * @param button
	 */
	public void addListener(JButton button) {
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(button.isEnabled()) {
					//按钮点击事件
					buttonClicked(button);
				}
			}
		};
		button.addMouseListener(mouseAdapter);
	}
	
	/**
	 * buttonClicked:(按钮点击事件)
	 * @author xiangning
	 *
	 */
	private void buttonClicked(JButton button) {
		int current = currentPage;
		String text = button.getText();
		if(PRE_TEXT.equals(text) && currentPage > 1 ) {
			//如果点击的是上一页,同时当前页又是在2或以上,那么设置下面要跳转的页为当前页-1
			current = currentPage - 1;
		}else if(NEXT_TEXT.equals(text) && currentPage < pageSize) {
			current = currentPage + 1;
		}else if (StringUtil.isNum(text)) {
			current = StringUtil.toInt(text);
		}
		if(current <= 0 || current == currentPage) {
			//如果当前页小于1  或者是与原先一样的,那么不做操作
			return;
		}
		currentPage = current;
		updateData();
		
	}
	
	
	private void updateData() {
		pagination.update(this, rows, currentPage);
	}
	
	
}
