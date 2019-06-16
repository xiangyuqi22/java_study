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
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javastudy_m</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月4日
 * @author xiangning
 * @since JDK1.8
 */
public class MergePictureDemo2 {
	
	
	private static String format = "mp4";

	public static void main(String[] args) throws Exception {
		System.out.println("start...");
		String saveMp4name = "E:\\data\\temp\\hdmi\\image\\images\\f1." + format; //保存的视频名称
		// 目录中所有的图片，都是jpg的，以1.jpg,2.jpg的方式，方便操作
		String imagesPath = "E:\\data\\temp\\hdmi\\image\\images\\test"; // 图片集合的目录
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
		// 列出目录中所有的图片，都是jpg的，以1.jpg,2.jpg的方式，方便操作
		File file = new File(imagesPath);
		File[] flist = file.listFiles();
		// 循环所有图片
		for(int i = 0; i < flist.length; i++ ){
			String fname = flist[i].getAbsolutePath();
			System.out.println(fname);
			IplImage image = cvLoadImage(fname); // 非常吃内存！！
			recorder.record(conveter.convert(image));
			// 释放内存？ cvLoadImage(fname); // 非常吃内存！！
			opencv_core.cvReleaseImage(image);
		}
		recorder.stop();
		recorder.release();
	}


}
