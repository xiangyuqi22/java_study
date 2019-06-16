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

import java.nio.IntBuffer;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_highgui.CvTrackbarCallback;
import org.bytedeco.javacpp.opencv_videoio.CvCapture;
import org.bytedeco.javacpp.opencv_videoio.VideoCapture;

import static org.bytedeco.javacpp.opencv_highgui.*;

public class Trackbar {
public static void main(String[] args) {
	/*//���������ֵ
	int switchValue =30;
	//ÿ֡Ҫ��ʾ��ͼ��
	IplImage frammeImage = null;
	//�ص���������
	SwitchCallBack switchCallBack =  new SwitchCallBack();
	VideoCapture video = new VideoCapture();
    video.open("files/hockey.avi");
	//��ȡ��Ƶ
	CvCapture cvCapture = cvCreateFileCapture("resources/when.avi");
	if (cvCapture==null) {
		System.out.println("��ȡ�ļ�����");
		return;
	}
	//�������ڣ���С�ɵ���
	cvNamedWindow("Trackbar", 0);
	cvCreateTrackbar(
			//������������
		    "Progress",
		    //���ڵ�����
		    "Trackbar",
		    //��ǰ��������ֵ
		    switchCallBack.getIntBuffer(),
		    //���������ֵ
		    switchValue,
		    //�ص���������
		    switchCallBack
		  );
	while(true) {
		//ֻҪ��������û���ϵ���󣬾ͽ��в���
	    if(switchCallBack.getIntBuffer().get(0)!=30&&switchCallBack.getIntBuffer().get(0)!=0){
	    	frammeImage = cvQueryFrame(cvCapture);
	   	 	if(frammeImage==null) break;
	    }
	    //չʾ��ǰ֡����ʵ����Ƶ�Ĳ���
	    cvShowImage( "Trackbar", frammeImage);
	    if(cvWaitKey(10)==27 ){
	    	break;
	    } 
	  }
	//�ͷ���Դ
	cvReleaseCapture(cvCapture);
	cvDestroyWindow("Trackbar");*/
}

}
/**
* @����˵����ʵ���϶��������Ĺ����еĺ����ص�
* @time:2014��7��19������6:05:28
* @version:1.0
*
*/
class SwitchCallBack extends CvTrackbarCallback{
	private IntBuffer intBuffer = IntBuffer.allocate(30);
	@Override
	public void call(int position){
		//��������ǰλ����0����ʾ�ر�
		if (position ==0) {
			switchBegin();
			intBuffer.clear();
			intBuffer.put(position);
		//��������ǰλ����30�����Ž���
		}else if(position==30){
			switchEnd();
			intBuffer.clear();
			intBuffer.put(position);
		//��ս���������ֵ�����뵱ǰֵ
		}else{
			intBuffer.clear();
			intBuffer.put(position);
			switchOn();
		}
		
	}
	public void switchOn(){
		System.out.println("���ڲ���:");
	}
	public void switchBegin(){
		System.out.println("������ʼ���ţ�");
	}
	public void switchEnd(){
		System.out.println("�������");
	}
	public IntBuffer getIntBuffer() {
		return intBuffer;
	}
	public void setIntBuffer(IntBuffer intBuffer) {
		this.intBuffer = intBuffer;
	}
	
}