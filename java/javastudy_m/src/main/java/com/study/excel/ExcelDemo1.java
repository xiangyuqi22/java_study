package com.study.excel;
/**
 * <PRE>
 * excel��������demo
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��14��
 * @author xiangning
 * @since JDK1.8
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;

import com.study.utils.StringUtil;


public class ExcelDemo1 {
	public static void main(String[] args) throws Exception {
        // excel2003������
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Sheet 1");
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        // ���þ�������
        List<String> timeList = new ArrayList<String>();
        timeList.add("10:00");
        timeList.add("11:00");
        timeList.add("12:00");
        List<Integer> appList = new ArrayList<Integer>();
        appList.add(120);
        appList.add(200);
        appList.add(150);
        List<Integer> oraList = new ArrayList<Integer>();
        oraList.add(230);
        oraList.add(200);
        oraList.add(235);
        // ����ͼƬ�е��������ɫ�Լ��ֺ�
        Font titleFont = new Font("����", Font.BOLD, 12);
        Font xfont = new Font("����", Font.BOLD, 10);
        Font labelFont = new Font("����", Font.BOLD, 10);
        // ������������
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < timeList.size(); i++) {
            String time = timeList.get(i);
            dataset.addValue(appList.get(i), "ƻ��", time);
            dataset.addValue(oraList.get(i), "����", time);
        }
        JFreeChart chart = ChartFactory.createLineChart("ˮ��ʱ�������", "ʱ��", "����", dataset, PlotOrientation.VERTICAL, true,
            true, true);
        // ����ͼ������
        chart.getLegend().setItemFont(new Font("����", Font.BOLD, 20));
        // ���ñ�������
        chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));
        // ͼ�εĻ��ƽṹ����
        CategoryPlot plot = chart.getCategoryPlot();
        // ��ȡ��ʾ�����Ķ���
        LineAndShapeRenderer lasp = (LineAndShapeRenderer) plot.getRenderer();
        // ���ùյ��Ƿ�ɼ�/�Ƿ���ʾ�յ�
        lasp.setBaseShapesVisible(true);
        // ���ùյ㲻ͬ�ò�ͬ����״
        lasp.setDrawOutlines(true);
        // ���������Ƿ���ʾ�����ɫ
        lasp.setUseFillPaint(false);
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        // �������ߴ�С�Լ����ߵ���ɫ
        renderer.setSeriesStroke(0, new BasicStroke(1.0F));
        renderer.setSeriesPaint(0, new Color(210, 105, 30));
        renderer.setSeriesStroke(1, new BasicStroke(1.0F));
        renderer.setSeriesPaint(1, new Color(0, 191, 255));
        // �����۵�Ĵ�С
        lasp.setSeriesOutlineStroke(0, new BasicStroke(0.025F));
        lasp.setSeriesOutlineStroke(1, new BasicStroke(0.05F));
        // ����������
        plot.setDomainGridlinePaint(Color.gray);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.gray);
        plot.setRangeGridlinesVisible(true);
        // x��
        CategoryAxis domainAxis = plot.getDomainAxis();
        // ����x�᲻��ʾ������x����������غ�
        domainAxis.setAxisLineVisible(false);
        // x�����
        domainAxis.setLabelFont(xfont);
        // x��������б
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.95D));
        // X����������ֵ����
        domainAxis.setTickLabelFont(labelFont);
        // ����Y����
        NumberAxis numAxis = (NumberAxis) plot.getRangeAxis();
        numAxis.setTickUnit(new NumberTickUnit(50));
        // y��
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLabelFont(xfont);
        // ����y�᲻��ʾ�������������غ�
        rangeAxis.setAxisLineVisible(false);
        // y����������ֵ����
        rangeAxis.setTickLabelFont(labelFont);
        rangeAxis.setFixedDimension(0);
        CategoryPlot cp = chart.getCategoryPlot();
        // ����ɫ����
        cp.setBackgroundPaint(ChartColor.WHITE);
        cp.setRangeGridlinePaint(ChartColor.GRAY);
        // ����ͼ��������ͼ����λ�ã����������ʵ�ʲ������ã���ô�趼���±�
        LegendTitle legendTitle = new LegendTitle(chart.getPlot());
        legendTitle.setPosition(RectangleEdge.BOTTOM);
        try {
            ChartUtilities.writeChartAsPNG(byteArrayOut, chart, 400, 200);
            String fileSavePath = "exTest.png";
            BufferedImage bufferImg = ImageIO.read(new File(fileSavePath));
            ImageIO.write(bufferImg, "png", byteArrayOut);
        } catch (IOException e) {
        }
        // ��ͼ�Ķ�����������һ��sheetֻ�ܻ�ȡһ����һ��Ҫע����㣩
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // �˸�������ǰ�ĸ���ʾͼƬ����ʼ��Ԫ��ͽ�����Ԫ���Ե��λ�ã�
        // ���ĸ���ʾ��ʼ�ͽ�����Ԫ���λ�ã����±�ʾ�ӵ�2�е���12�У��ӵ�1�е���15��,��Ҫע��excel��ʼλ����0
        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) 2, (short) 1, (short) 12, (short) 15);
//        anchor.setAnchorType(3);
        // ����ͼƬ
        patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));
        // excel2003��׺
        String fileName = StringUtil.getNowTime3();
        FileOutputStream fileOut = new FileOutputStream("E:\\data\\excel\\" + fileName + ".xls");
        wb.write(fileOut);
        fileOut.close();
    }
}
