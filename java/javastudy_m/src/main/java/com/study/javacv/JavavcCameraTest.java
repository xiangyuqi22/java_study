package com.study.javacv;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月30日
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
 * 调用本地摄像头窗口视频
 * @author eguid  
 * @version 2016年6月13日  
 * @see javavcCameraTest  
 * @since  javacv1.2
 */
 
public class JavavcCameraTest
{
public static void main(String[] args) throws Exception, InterruptedException
{
    OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);  
    grabber.start();   //开始获取摄像头数据
    CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
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
        {//窗口是否关闭
            grabber.stop();//停止抓取
            System.exit(2);//退出
        }
        canvas.setCanvasSize(1280, 720);
        Frame frame = grabber.grab();
        frame.imageWidth = 1280;
        frame.imageHeight = 720;
        canvas.showImage(frame);//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
 
        Thread.sleep(10);//50毫秒刷新一次图像
    }
}
}
