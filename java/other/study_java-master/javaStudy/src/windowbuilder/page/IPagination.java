package windowbuilder.page;

import javax.swing.JPanel;

/**
 * <PRE>
 * ��ҳ�ص��ӿ�
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��24��
 * @author xiangning
 * @since JDK1.8
 */
public interface IPagination {
	
	
	public void update(JPanel pagePanel,int rows,int currentPage);

}
