package windowbuilder.jbutton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�stbrecorder</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��19��
 * @author xiangning
 * @since JDK1.8
 */
public class StbButtonGroup extends ButtonGroup {
	
	
	
	/**
	 * add:(��Ӱ�ť)
	 * @author xiangning
	 *
	 * @param b						��ť
	 * @param selected				�Ƿ�Ĭ������ѡ��
	 * @param atWillSelected		�Ƿ�������������ѡ��
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
