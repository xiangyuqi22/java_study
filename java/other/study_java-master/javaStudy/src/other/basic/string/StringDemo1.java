package other.basic.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��7��4��
 * @author xiangning
 * @since JDK1.8
 */
public class StringDemo1 {
	
	public static void main(String[] args) {
		
		Map paramMap = new HashMap<>();
		
		
		new ArrayList<>(new HashSet());
		
		
		//���ݻ�����id��ѯȱ������
		//���ݻ�����id��ѯ��־����Ľű�
		
		System.out.println(new HashMap<>().get("a") + "");
		
		String originName = "mystudy.jpg";
		String suffix = originName.substring(originName.lastIndexOf("."),originName.length());
		System.out.println(suffix);
	}

}
