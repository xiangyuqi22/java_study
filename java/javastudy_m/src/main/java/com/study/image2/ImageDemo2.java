package com.study.image2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
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
public class ImageDemo2 {
	// ȫ����
	public static void main(String[] args) throws IOException {
	    // ��ȡͼ��
//	    File imageFile = new File("E:\\data\\22.jpg");
	    int[] pixels1 = get(new File("E:\\data\\112.png"));
	    int[] pixels2 = get(new File("E:\\data\\114.png"));
	    // ��ȡ����ͼ�ĺ������루������һ��ͼҲ�Ѿ������沽��õ��ҶȱȽ����飩
	    int hammingDistance = getHammingDistance(pixels1, pixels2);
	    // ͨ����������������ƶȣ�ȡֵ��Χ [0.0, 1.0]
	    double similarity = calSimilarity(hammingDistance);
	    System.out.println(similarity);
	}

	private static int[] get(File imageFile) throws IOException {
		Image image = ImageIO.read(imageFile);
	    // ת�����Ҷ�
	    image = toGrayscale(image);
	    // ��С��32x32������ͼ
	    image = scale(image);
	    // ��ȡ�Ҷ���������
	    int[] pixels = getPixels(image);
	    // ��ȡƽ���Ҷ���ɫ
	    int averageColor = getAverageOfPixelArray(pixels);
	    // ��ȡ�Ҷ����صıȽ����飨��ͼ��ָ�����У�
	    pixels = getPixelDeviateWeightsArray(pixels, averageColor);
		return pixels;
	}

	// ������Image����ͼ��ת��ΪBufferedImage���ͣ������������
	public static BufferedImage convertToBufferedFrom(Image srcImage) {
	    BufferedImage bufferedImage = new BufferedImage(srcImage.getWidth(null),
	            srcImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = bufferedImage.createGraphics();
	    g.drawImage(srcImage, null, null);
	    g.dispose();
	    return bufferedImage;
	}

	// ת�����Ҷ�ͼ
	public static BufferedImage toGrayscale(Image image) {
	    BufferedImage sourceBuffered = convertToBufferedFrom(image);
	    ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
	    ColorConvertOp op = new ColorConvertOp(cs, null);
	    BufferedImage grayBuffered = op.filter(sourceBuffered, null);
	    return grayBuffered;
	}

	// ������32x32��������ͼ
	public static Image scale(Image image) {
	    image = image.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	    return image;
	}

	// ��ȡ��������
	public static int[] getPixels(Image image) {
	    int width = image.getWidth(null);
	    int height = image.getHeight(null);
	    int[] pixels = convertToBufferedFrom(image).getRGB(0, 0, width, height,
	            null, 0, width);
	    return pixels;
	}

	// ��ȡ�Ҷ�ͼ��ƽ��������ɫֵ
	public static int getAverageOfPixelArray(int[] pixels) {
	    Color color;
	    long sumRed = 0;
	    for (int i = 0; i < pixels.length; i++) {
	        color = new Color(pixels[i], true);
	        sumRed += color.getRed();
	    }
	    int averageRed = (int) (sumRed / pixels.length);
	    return averageRed;
	}

	// ��ȡ�Ҷ�ͼ�����رȽ����飨ƽ��ֵ����
	public static int[] getPixelDeviateWeightsArray(int[] pixels,final int averageColor) {
	    Color color;
	    int[] dest = new int[pixels.length];
	    for (int i = 0; i < pixels.length; i++) {
	        color = new Color(pixels[i], true);
	        dest[i] = color.getRed() - averageColor > 0 ? 1 : 0;
	    }
	    return dest;
	}

	// ��ȡ��������ͼ��ƽ�����رȽ�����ĺ������루����Խ�����Խ��
	public static int getHammingDistance(int[] a, int[] b) {
	    int sum = 0;
	    for (int i = 0; i < a.length; i++) {
	        sum += a[i] == b[i] ? 0 : 1;
	    }
	    return sum;
	}

	// ͨ����������������ƶ�
	public static double calSimilarity(int hammingDistance){
	    int length = 32*32;
	    double similarity = (length - hammingDistance) / (double) length;

	    // ʹ��ָ�����ߵ������ƶȽ��
	    similarity = java.lang.Math.pow(similarity, 2);
	    return similarity;
	}
}
