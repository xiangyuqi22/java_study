package windowbuilder.jtree.demo2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��22��
 * @author xiangning
 * @since JDK1.8
 */
public class FunctionJscrollpanel extends JScrollPane {
	
	public FunctionJscrollpanel() {
		FuntionTree tree = new FuntionTree();
		this.setViewportView(tree);
	}

}
