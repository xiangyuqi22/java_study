package com.study.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��6��
 * @author xiangning
 * @since JDK1.8
 */
public class ImageMain1 {
	
	public static void main(String[] args) throws IOException {
		long start  = System.currentTimeMillis();
		BufferedImage image1 = ImageIO.read(new File("E:\\data\\112.png"));
        BufferedImage image2 = ImageIO.read(new File("E:\\data\\113.png"));
        ImageColorHistogramSimilarity is = new ImageColorHistogramSimilarity();
        double rate = is.colorHistogramSimilarity(image1,image2);
        System.out.println(rate);
        System.out.println((System.currentTimeMillis() - start));
	}

}
