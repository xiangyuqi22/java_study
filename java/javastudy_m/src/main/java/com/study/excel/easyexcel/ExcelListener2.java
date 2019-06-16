package com.study.excel.easyexcel;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.study.excel.bean.BugCount;


/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月14日
 * @author xiangning
 * @since JDK1.8
 */
public class ExcelListener2 extends AnalysisEventListener<BugCount> {

	private List<BugCount> list = new ArrayList<BugCount>();

	@Override
	public void invoke(BugCount bugCount, AnalysisContext context) {
		// TODO Auto-generated method stub
		Integer currentRowNum = context.getCurrentRowNum();

		 list.add(bugCount);
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {
		// System.out.println(list);
//		list.forEach((bugCount) -> {
//			System.out.println(bugCount);
//		});
//		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " --> " + list.get(i) );
		}

	}

}
