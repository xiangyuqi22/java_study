package com.study.excel.easyexcel;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;

/* ������������
 * ÿ����һ�л�ص�invoke()������
 * ����excel����������ִ��doAfterAllAnalysed()����
 *
 * ����ֻ����д��һ���������ѣ����Ը����Լ����߼��޸ĸ��ࡣ
 * @author jipengfei
 * @date 2017/03/14
 */
public class ExcelListener extends AnalysisEventListener<List> {

    //�Զ���������ʱ�洢data��
    //����ͨ��ʵ����ȡ��ֵ
    private List<Object> datas = new ArrayList<Object>();
    
    @Override
    public void invoke(List object, AnalysisContext context) {
        System.out.println("��ǰ�У�"+context.getCurrentRowNum());
        System.out.println(object);
        datas.add(object);//���ݴ洢��list������������������Լ�ҵ���߼�����
        doSomething(object);//�����Լ�ҵ��������
    }
    
    
    private void doSomething(Object object) {
        //1�������ýӿ�
    }
    
    
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
       // datas.clear();//�����������ٲ��õ���Դ
    }
    
    
    public List<Object> getDatas() {
        return datas;
    }
    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}