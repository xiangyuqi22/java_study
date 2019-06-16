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
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��1��31��
 * @author xiangning
 * @since JDK1.8
 */
public class JavacvTest2 {

	
	private static CanvasFrame frame;
	private static FrameRecorder recorder;
	private static FrameGrabber grabber;

	/**
	 * ��֡¼�Ʊ�������ͷ��Ƶ����Ԥ����¼�ƣ�ֹͣԤ����ֹͣ¼�ƣ�
	 * 
	 * @author eguid
	 * @param outputFile -¼�Ƶ��ļ�·����Ҳ������rtsp����rtmp����ý�������������ַ
	 * @param frameRate - ��Ƶ֡��
	 * @throws Exception
	 * @throws InterruptedException
	 * @throws org.bytedeco.javacv.FrameRecorder.Exception
	 */
	public static void recordCamera(String outputFile, double frameRate)
			throws Exception, InterruptedException, org.bytedeco.javacv.FrameRecorder.Exception {
		Loader.load(opencv_objdetect.class);
		grabber = FrameGrabber.createDefault(0);//��������ͷĬ��0������ʹ��javacv��ץȡ��������ʹ�õ���ffmpeg����opencv�������в鿴Դ��
		grabber.setImageHeight(1080);
		grabber.setImageWidth(2048);
		grabber.start();//����ץȡ��
		System.out.println("grabber.getImageWidth() = " + grabber.getImageWidth());
		System.out.println("grabber.getFormat() = " + grabber.getFormat());
 
		OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();//ת����
		IplImage grabbedImage = converter.convert(grabber.grab());//ץȡһ֡��Ƶ������ת��Ϊͼ�����������ͼ��������ʲô����ˮӡ������ʶ��ȵ��������
		int width = grabbedImage.width();
		int height = grabbedImage.height();
		System.out.println(width);
		System.out.println(height);
		recorder = FrameRecorder.createDefault(outputFile, width, height);
		recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264); // avcodec.AV_CODEC_ID_H264������
		recorder.setFormat("mp4");//��װ��ʽ����������͵�rtmp�ͱ�����flv��װ��ʽ
		recorder.setFrameRate(frameRate);
		
		recorder.start();//����¼����
		long startTime=0;
		long videoTS=0;
		frame = new CanvasFrame("camera", CanvasFrame.getDefaultGamma());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		Frame rotatedFrame=converter.convert(grabbedImage);//��֪��Ϊʲô���ﲻ��ת���Ͳ����Ƶ�rtmp
		//�������ڹر�
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
