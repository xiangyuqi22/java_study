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

import java.nio.IntBuffer;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_highgui.CvTrackbarCallback;
import org.bytedeco.javacpp.opencv_videoio.CvCapture;
import org.bytedeco.javacpp.opencv_videoio.VideoCapture;

import static org.bytedeco.javacpp.opencv_highgui.*;

public class Trackbar {
public static void main(String[] args) {
	/*//进度条最大值
	int switchValue =30;
	//每帧要显示的图像
	IplImage frammeImage = null;
	//回调方法载体
	SwitchCallBack switchCallBack =  new SwitchCallBack();
	VideoCapture video = new VideoCapture();
    video.open("files/hockey.avi");
	//读取视频
	CvCapture cvCapture = cvCreateFileCapture("resources/when.avi");
	if (cvCapture==null) {
		System.out.println("读取文件出错！");
		return;
	}
	//创建窗口，大小可调整
	cvNamedWindow("Trackbar", 0);
	cvCreateTrackbar(
			//进度条的名称
		    "Progress",
		    //窗口的名称
		    "Trackbar",
		    //当前进度条的值
		    switchCallBack.getIntBuffer(),
		    //进度条最大值
		    switchValue,
		    //回调函数载体
		    switchCallBack
		  );
	while(true) {
		//只要进度条，没有拖到最后，就进行播放
	    if(switchCallBack.getIntBuffer().get(0)!=30&&switchCallBack.getIntBuffer().get(0)!=0){
	    	frammeImage = cvQueryFrame(cvCapture);
	   	 	if(frammeImage==null) break;
	    }
	    //展示当前帧，以实现视频的播放
	    cvShowImage( "Trackbar", frammeImage);
	    if(cvWaitKey(10)==27 ){
	    	break;
	    } 
	  }
	//释放资源
	cvReleaseCapture(cvCapture);
	cvDestroyWindow("Trackbar");*/
}

}
/**
* @功能说明：实现拖动进度条的过程中的函数回调
* @time:2014年7月19日下午6:05:28
* @version:1.0
*
*/
class SwitchCallBack extends CvTrackbarCallback{
	private IntBuffer intBuffer = IntBuffer.allocate(30);
	@Override
	public void call(int position){
		//进度条当前位置在0，提示关闭
		if (position ==0) {
			switchBegin();
			intBuffer.clear();
			intBuffer.put(position);
		//进度条当前位置是30，播放结束
		}else if(position==30){
			switchEnd();
			intBuffer.clear();
			intBuffer.put(position);
		//清空进度条缓存值，放入当前值
		}else{
			intBuffer.clear();
			intBuffer.put(position);
			switchOn();
		}
		
	}
	public void switchOn(){
		System.out.println("正在播放:");
	}
	public void switchBegin(){
		System.out.println("即将开始播放！");
	}
	public void switchEnd(){
		System.out.println("播放完毕");
	}
	public IntBuffer getIntBuffer() {
		return intBuffer;
	}
	public void setIntBuffer(IntBuffer intBuffer) {
		this.intBuffer = intBuffer;
	}
	
}