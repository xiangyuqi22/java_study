package other.basic.java.String;

import java.util.UUID;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��11��
 * @author xiangning
 * @since JDK1.8
 */
public class StringDemo1 {
	
	public static void main(String[] args) {
		String originalFilename = "xiangning.zip";
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
		System.out.println(suffix);
		String uuidName = UUID.randomUUID().toString() + suffix;
		System.out.println(uuidName);
	}

}
