package com.study.javacv;

import static org.bytedeco.javacpp.opencv_highgui.imshow;
import static org.bytedeco.javacpp.opencv_highgui.waitKey;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import org.bytedeco.javacpp.opencv_core.Mat;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��1��30��
 * @author xiangning
 * @since JDK1.8
 */
public class HelloJavacv {
	
	public static void main(String[] args) {
		//��ȡԭʼͼƬ
        Mat image = imread("E:\\data\\temp\\hdmi\\timg.jpg"); 
        if (image.empty()) {
            System.err.println("����ͼƬ��������ͼƬ·����");
            return;
        }
        //��ʾͼƬ 
        imshow("��ʾԭʼͼ��", image);

        //���޵ȴ���������
        waitKey(0);
	}
}
