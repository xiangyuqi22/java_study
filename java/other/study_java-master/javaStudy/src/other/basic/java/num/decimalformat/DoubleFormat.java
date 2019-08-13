package other.basic.java.num.decimalformat;

import java.text.DecimalFormat;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��7��16��
 * @author xiangning
 * @since JDK1.8
 */
public class DoubleFormat {
	
	public static void main(String[] args) {
		
		String showText = getShowText("0.123,0.323,0.432432432432,0.432432432423");
		System.out.println(showText);
		
	}
	
	public static final String FOUR_NUM_REGEX = "0.\\d+,0.\\d+,0.\\d+,0.\\d+";
	
	public static final String COMMA = ",";
	
	static DecimalFormat    DECIMAL_FORMAT   = new DecimalFormat("######0.00");   

	protected static String getShowText(String paramValue) {
		
		/**
		 * ����ʾ���ݵ���ֵ��С������λ������
		 */
		String value = paramValue;
		if(paramValue.matches(FOUR_NUM_REGEX)) {
			StringBuilder sb = new StringBuilder();
			paramValue.split(",");
			String [] strs = paramValue.split(COMMA);
			sb.append(DECIMAL_FORMAT.format(Double.parseDouble(strs[0]))).append(COMMA)
			.append(DECIMAL_FORMAT.format(Double.parseDouble(strs[1]))).append(COMMA)
			.append(DECIMAL_FORMAT.format(Double.parseDouble(strs[2]))).append(COMMA)
			.append(DECIMAL_FORMAT.format(Double.parseDouble(strs[3])));
			value = sb.toString();
		}
		
		
		return "�������:" + value;
	}
	

}
