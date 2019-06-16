package com.study.javacv;
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


import java.awt.image.BufferedImage;

import javax.swing.JFrame;
 
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameGrabber;
 
/**
 * ���ñ�������ͷ������Ƶ
 * @author eguid  
 * @version 2016��6��13��  
 * @see javavcCameraTest  
 * @since  javacv1.2
 */
 
public class JavavcCameraTest
{
public static void main(String[] args) throws Exception, InterruptedException
{
    OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);  
    grabber.start();   //��ʼ��ȡ����ͷ����
    CanvasFrame canvas = new CanvasFrame("����ͷ");//�½�һ������
    System.out.println(grabber.getFrameRate());
    System.out.println(grabber.getFormat());
    System.out.println(grabber.getPixelFormat());
    System.out.println(grabber.getVideoBitrate());
    canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    canvas.setAlwaysOnTop(true);
    canvas.getContentPane();
   /* JFrame frame = new JFrame();
    frame.setContentPane(canvas.getContentPane());
    frame.setBounds(0, 0, 200, 200);
    frame.setVisible(true);*/
    //BufferedImage b = new BufferedImage(100, 100, 1);
    
    while(true)
    {
        if(!canvas.isDisplayable())
        {//�����Ƿ�ر�
            grabber.stop();//ֹͣץȡ
            System.exit(2);//�˳�
        }
        canvas.setCanvasSize(1280, 720);
        Frame frame = grabber.grab();
        frame.imageWidth = 1280;
        frame.imageHeight = 720;
        canvas.showImage(frame);//��ȡ����ͷͼ�񲢷ŵ���������ʾ�� �����Frame frame=grabber.grab(); frame��һ֡��Ƶͼ��
 
        Thread.sleep(10);//50����ˢ��һ��ͼ��
    }
}
}
