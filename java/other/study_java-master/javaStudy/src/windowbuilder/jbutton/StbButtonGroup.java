package windowbuilder.jbutton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：stbrecorder</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月19日
 * @author xiangning
 * @since JDK1.8
 */
public class StbButtonGroup extends ButtonGroup {
	
	
	
	/**
	 * add:(添加按钮)
	 * @author xiangning
	 *
	 * @param b						按钮
	 * @param selected				是否默认设置选中
	 * @param atWillSelected		是否添加无条件点击选中
	 */
	public void add(JButton b , boolean selected , boolean atWillSelected) {
		super.add(b);
		if(selected) {
			this.setSelected(b, true);
		}
		if(atWillSelected) {
			b.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					setSelected(b, true);
				}
				
			});
		}
	}

	public void setSelected(JButton button, boolean b) {
		super.clearSelection();
		super.setSelected(button.getModel(), b);
	}
	
}
