package windowbuilder.jtable.demo2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月26日
 * @author xiangning
 * @since JDK1.8
 */
public class JTableDemo2Model extends AbstractTableModel{
	
	protected List<List<Point>> gridInfo = new Vector<List<Point>>();

	//private String[] columnNames = { "First Name", "Last Name", "Sport", "# of Years", "Vegetarian" };
	private Object[][] data = 
			{ 
			{ "点击按键", "开机", "修改/删除"},
			{ "休眠", "3000", "修改/删除"},
			{ "点击按键", "下", "修改/删除"},
			{ "点击按键", "下", "修改/删除"},
			{ "点击按键", "右", "修改/删除"},
			{ "点击按键", "确定", "修改/删除"},
			{ "点击按键", "确定", "修改/删除"},
			{ "休眠", "3000", "修改/删除"},
			{ "视频检查", "马赛克", "修改/删除"},
			{ "视频检查", "卡顿", "修改/删除"},
			{ "音频检查", "唇音同步", "修改/删除"},
			{ "图像判断", "", "修改/删除"},
			{ "记录时间", "", "修改/删除"},
			{ "计算时间差", "", "修改/删除"},
			{ "调用脚本", "测试收藏脚本", "修改/删除"},
			};
	
	private String[] columnNames = {"序号", "命令", "参数", "操作"};
	

	
	public int getRowCount() {
		return data.length;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0 ) {
			return rowIndex + 1;
		}
		return data[rowIndex][--columnIndex];
	}
	
	 public String getColumnName(int column) {
		 return columnNames[column];
	 }


	/**
	 * 设置可编辑的单元格
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex == 2) {
			//设定参数那一行为可编辑
			return true;
		}
		return false;
	}


	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		System.out.println(aValue);
		data[rowIndex][--columnIndex] = aValue;
	}
	
	
	 //---------------------------------------------------

	public boolean mergeCells(int[] rows, int[] columns) {
		Arrays.sort(rows);
		Arrays.sort(columns);
		return mergeCells(rows[0],rows[rows.length-1],columns[0],columns[columns.length-1]);
	}
	
	public boolean mergeCells(int startRow, int endRow, int startColumn, int endColumn) {
		setGrid(startRow, startColumn, new Point(endColumn-startColumn+1, endRow-startRow+1)); 
		for(int row=startRow; row<=endRow; row++){
			for(int col=startColumn; col<=endColumn; col++){
				if(row==startRow&&col==startColumn)
					continue;
				else
					setGrid(row, col, new Point(0,0)); 
			}
		}
		return true;
	}
	
	protected boolean setGrid(int row, int column, Point grid) {
		if( gridInfo != null && row >=0 && row < gridInfo.size() ){
			List<Point> gridRow = gridInfo.get(row);
			if( gridRow != null && column >=0 && column < gridRow.size() ){
				Point point = gridRow.get(column);
				if( point != null ){
					point.setLocation(grid);
				}
				else{
					gridRow.set(column, grid.getLocation());
				}
				return true;
			}	
		}
		return false;
	}
	
	public int getColumnGrid(int row, int column) {
		if( gridInfo != null && row >=0 && row < gridInfo.size() ){
			List<Point> gridRow = gridInfo.get(row);
			if( gridRow != null && column >=0 && column < gridRow.size() ){
				Point point = gridRow.get(column);
				if( point != null )
					return point.x;
			}	
		}
		return 1;
	}
	
	public int getRowGrid(int row, int column) {
		if( gridInfo != null && row >=0 && row < gridInfo.size() ){
			List<Point> gridRow = gridInfo.get(row);
			if( gridRow != null && column >=0 && column < gridRow.size() ){
				Point point = gridRow.get(column);
				if( point != null )
					return point.y;
			}	
		}
		return 1;
	}



}
