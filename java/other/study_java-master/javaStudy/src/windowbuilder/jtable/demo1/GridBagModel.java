package windowbuilder.jtable.demo1;
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
import java.awt.Point;

public interface GridBagModel {
	//���Ӵ�������״̬
	int DEFAULT = 0;
	//���Ӻϲ��������ĸ���
	int MERGE = 1;
	//���ӱ��������Ӻϲ�
	int COVERED = -1;
	
	/**
	 * @param row ��
	 * @param column ��
	 * @return �õ�Ԫ�����С��еĿ��
	 */
	Point getGrid(int row, int column);
	
	/**
	 * ��Y�᷽��Ŀ��
	 * @param row
	 * @param column
	 * @return
	 */
	int getRowGrid(int row, int column);
	
	/**
	 * ��X�᷽��Ŀ��
	 * @param row
	 * @param column
	 * @return
	 */
	int getColumnGrid(int row, int column);

	/**
	 * @param rows �м���
	 * @param columns �м���
	 * @return ��Ԫ�񼯺��Ƿ���Ժϲ���һ��
	 */
	boolean canMergeCells(int[] rows, int[] columns);
	
	/**
	 * �жϸõ�Ԫ��״̬
	 * @param row
	 * @param column
	 * @return MERGE|DEFAULT|COVERED
	 */
	int getCellState(int row, int column);
	
	/**
	 * ����Ԫ�񼯺Ϻϲ�
	 * @param startRow ��ʼ��
	 * @param endRow ������
	 * @param startColumn ��ʼ��
	 * @param endColumn ������
	 * @return �Ƿ�ϲ��ɹ�
	 */
	boolean mergeCells(int startRow, int endRow, int startColumn, int endColumn);
	
	/**
	 * ����Ԫ�񼯺Ϻϲ�
	 * @param rows �м���
	 * @param columns �м���
	 * @return �Ƿ�ϲ��ɹ�
	 */
	boolean mergeCells(int[] rows, int[] columns);
	
	/**
	 * ��ֵ�Ԫ��
	 * @param row ��
	 * @param column ��
	 * @return �Ƿ��ֳɹ�
	 */
	boolean spliteCellAt(int row, int column);
	
	/**
	 * ��� ���кϲ�
	 */
	void clearMergence();
}
