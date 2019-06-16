package com.study.javacv;


import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
 
import java.io.File;
 
import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;


/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javastudy_m</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��4��
 * @author xiangning
 * @since JDK1.8
 */
public class MergePictureDemo2 {
	
	
	private static String format = "mp4";

	public static void main(String[] args) throws Exception {
		System.out.println("start...");
		String saveMp4name = "E:\\data\\temp\\hdmi\\image\\images\\f1." + format; //�������Ƶ����
		// Ŀ¼�����е�ͼƬ������jpg�ģ���1.jpg,2.jpg�ķ�ʽ���������
		String imagesPath = "E:\\data\\temp\\hdmi\\image\\images\\test"; // ͼƬ���ϵ�Ŀ¼
		test(saveMp4name,imagesPath);
		System.out.println("end...");
	}
 
	public static void test(String saveMp4name,String imagesPath) throws Exception  {
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(saveMp4name,640,480);
//		recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264); // 28
//		recorder.setVideoCodec(avcodec.AV_CODEC_ID_FLV1); // 28
		recorder.setVideoCodec(avcodec.AV_CODEC_ID_MPEG4); // 13
//		recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264); // 13
	 	recorder.setFormat(format);
	//	recorder.setFormat("mov,mp4,m4a,3gp,3g2,mj2,h264,ogg,MPEG4");
		recorder.setFrameRate(0.5);
	 	recorder.setPixelFormat(0); // yuv420p
		recorder.start();
		//
		OpenCVFrameConverter.ToIplImage conveter = new OpenCVFrameConverter.ToIplImage();
		// �г�Ŀ¼�����е�ͼƬ������jpg�ģ���1.jpg,2.jpg�ķ�ʽ���������
		File file = new File(imagesPath);
		File[] flist = file.listFiles();
		// ѭ������ͼƬ
		for(int i = 0; i < flist.length; i++ ){
			String fname = flist[i].getAbsolutePath();
			System.out.println(fname);
			IplImage image = cvLoadImage(fname); // �ǳ����ڴ棡��
			recorder.record(conveter.convert(image));
			// �ͷ��ڴ棿 cvLoadImage(fname); // �ǳ����ڴ棡��
			opencv_core.cvReleaseImage(image);
		}
		recorder.stop();
		recorder.release();
	}


}
