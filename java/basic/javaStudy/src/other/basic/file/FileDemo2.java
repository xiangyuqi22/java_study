package other.basic.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月1日
 * @author xiangning
 * @since JDK1.8
 */
public class FileDemo2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		String path = "E:\\eclipse\\workspaces\\STP\\STP_interface\\stbrecorder\\data\\file\\temp\\content_img_20190401154417.jpg";
		File file = new File(path);
		System.out.println(file.exists());
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(file.canWrite());
				
			}
		}).start();
		FileInputStream fis = new FileInputStream(file);
		System.out.println(file.exists());
		
		
	}
}
