package com.study.javacv;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.helper.opencv_objdetect;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;


import org.bytedeco.javacpp.avcodec;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月31日
 * @author xiangning
 * @since JDK1.8
 */
public class JavacvTest2 {

	
	private static CanvasFrame frame;
	private static FrameRecorder recorder;
	private static FrameGrabber grabber;

	/**
	 * 按帧录制本机摄像头视频（边预览边录制，停止预览即停止录制）
	 * 
	 * @author eguid
	 * @param outputFile -录制的文件路径，也可以是rtsp或者rtmp等流媒体服务器发布地址
	 * @param frameRate - 视频帧率
	 * @throws Exception
	 * @throws InterruptedException
	 * @throws org.bytedeco.javacv.FrameRecorder.Exception
	 */
	public static void recordCamera(String outputFile, double frameRate)
			throws Exception, InterruptedException, org.bytedeco.javacv.FrameRecorder.Exception {
		Loader.load(opencv_objdetect.class);
		grabber = FrameGrabber.createDefault(0);//本机摄像头默认0，这里使用javacv的抓取器，至于使用的是ffmpeg还是opencv，请自行查看源码
		grabber.setImageHeight(1080);
		grabber.setImageWidth(2048);
		grabber.start();//开启抓取器
		System.out.println("grabber.getImageWidth() = " + grabber.getImageWidth());
		System.out.println("grabber.getFormat() = " + grabber.getFormat());
 
		OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();//转换器
		IplImage grabbedImage = converter.convert(grabber.grab());//抓取一帧视频并将其转换为图像，至于用这个图像用来做什么？加水印，人脸识别等等自行添加
		int width = grabbedImage.width();
		int height = grabbedImage.height();
		System.out.println(width);
		System.out.println(height);
		recorder = FrameRecorder.createDefault(outputFile, width, height);
		recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264); // avcodec.AV_CODEC_ID_H264，编码
		recorder.setFormat("mp4");//封装格式，如果是推送到rtmp就必须是flv封装格式
		recorder.setFrameRate(frameRate);
		
		recorder.start();//开启录制器
		long startTime=0;
		long videoTS=0;
		frame = new CanvasFrame("camera", CanvasFrame.getDefaultGamma());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		Frame rotatedFrame=converter.convert(grabbedImage);//不知道为什么这里不做转换就不能推到rtmp
		//监听窗口关闭
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent  e) {
				frame.dispose();
				try {
					recorder.stop();
					recorder.release();
					grabber.stop();
					grabber.release();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println("last");
			}
		});
		while (frame.isVisible() && (grabbedImage = converter.convert(grabber.grab())) != null) {
			rotatedFrame = converter.convert(grabbedImage);
			//rotatedFrame.imageWidth = 200;
			//rotatedFrame.imageHeight = 200;
			frame.showImage(rotatedFrame);
			if (startTime == 0) {
				startTime = System.currentTimeMillis();
			}
			videoTS = 1000 * (System.currentTimeMillis() - startTime);
			recorder.setTimestamp(videoTS);
			recorder.record(rotatedFrame);
			Thread.sleep(40);
		}
	}
	
	public static void main(String[] args) throws Exception, InterruptedException, org.bytedeco.javacv.FrameRecorder.Exception {
		recordCamera("output.mp4",25);
	}

}
