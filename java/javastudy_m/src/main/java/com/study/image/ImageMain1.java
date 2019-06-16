package com.study.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月6日
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
