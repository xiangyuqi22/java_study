package windowbuilder.jtable;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��7��22��
 * @author xiangning
 * @since JDK1.8
 */
public class TableDemo2 {
	 public static void main(String[] args) {
		    JTable t = new JTable(new TimesTableModel());
		    t.setDefaultRenderer(Object.class, new TimesTableRenderer());
		    JOptionPane.showMessageDialog(null, t);
		  }
		}

		class TimesTableRenderer extends DefaultTableCellRenderer {
		  @Override
		  public Component getTableCellRendererComponent(JTable table, Object value,
		      boolean isSelected, boolean hasFocus, int row, int column) {

		    Component c = super.getTableCellRendererComponent(table, value, isSelected,
		        hasFocus, row, column);
		    JComponent jc = (JComponent) c;
		    jc.setToolTipText((row + 1) + "x" + (column + 1) + "="
		        + ((row + 1) * (column + 1)));
		    return jc;
		  }
		}

		class TimesTableModel extends DefaultTableModel {
		  @Override
		  public int getColumnCount() {
		    return 7;
		  }

		  @Override
		  public int getRowCount() {
		    return 5;
		  }

		  @Override
		  public Object getValueAt(int row, int column) {
		    return new Integer((row + 1) * (column + 1));
		  }
		}
