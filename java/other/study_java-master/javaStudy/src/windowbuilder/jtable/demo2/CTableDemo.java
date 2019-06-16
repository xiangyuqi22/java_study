package windowbuilder.jtable.demo2;

import java.awt.Rectangle;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��26��
 * @author xiangning
 * @since JDK1.8
 */
public class CTableDemo extends JTable{
	
	
	public Rectangle getGridCellRect(int row, int column, boolean includeSpacing){
		return super.getCellRect(row, column, includeSpacing);
	}
	
	
	public Rectangle getCellRect(int row, int column, boolean includeSpacing) {		
		JTableDemo2Model model = (JTableDemo2Model)this.getModel();
		Rectangle cellRect = super.getCellRect(row, column, includeSpacing);
		int cols = model.getColumnGrid(row, column);
		TableColumnModel cm = getColumnModel();
		for( int n=1; n<cols; n++)
			cellRect.width += cm.getColumn(column+n).getWidth();
    	int rows = model.getRowGrid(row, column);
    	for( int n=1; n<rows; n++)
			cellRect.height += getRowHeight(row+n);
    	return cellRect;		 
	}

}
