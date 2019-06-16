package com.study.javacv;

import static org.bytedeco.javacpp.opencv_highgui.imshow;
import static org.bytedeco.javacpp.opencv_highgui.waitKey;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import org.bytedeco.javacpp.opencv_core.Mat;
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
public class HelloJavacv {
	
	public static void main(String[] args) {
		//读取原始图片
        Mat image = imread("E:\\data\\temp\\hdmi\\timg.jpg"); 
        if (image.empty()) {
            System.err.println("加载图片出错，请检查图片路径！");
            return;
        }
        //显示图片 
        imshow("显示原始图像", image);

        //无限等待按键按下
        waitKey(0);
	}
}
