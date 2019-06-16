package other.basic.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年2月14日
 * @author xiangning
 * @since JDK1.8
 */
public class PatternDemo {
	public static void main(String[] args) {
		
//		String str = "221211,212,32121,312";
//		String pattern = "\\d+,\\d+,\\d+,\\d+";
//		Pattern r = Pattern.compile(pattern);
//		Matcher m = r.matcher(str);
//		System.out.println(m.matches());
		
//		String str = "221211,212";
//		String pattern = "\\d+,\\d+";
//		Pattern r = Pattern.compile(pattern);
//		Matcher m = r.matcher(str);
//		System.out.println(m.matches());
		
//		String str = "22121";
//		String pattern = "\\d+";
//		Pattern r = Pattern.compile(pattern);
//		Matcher m = r.matcher(str);
//		System.out.println(m.matches());
		
		String str1 = "0.1,0.2,0.3,0.4";
		String pattern1 = "0.\\d+,0.\\d+,0.\\d+,0.\\d+";
		System.out.println(" str1.matches(pattern1) = " + str1.matches(pattern1));
		
		
		String str3 = "fsdf111 dsf";
		String pattern3 = "\\S*\\s*\\d+\\s*\\S*";
		System.out.println(" str1.matches(pattern2) = " + str3.matches(pattern3));
		
		
		
		String str = "案例五百11:11:22:22:332世界dds232";
		String pattern = "\\S*\\d+:\\d+\\S*";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		System.out.println(m.matches());
		System.out.println(str.matches(pattern));
		String str2 = "";
		boolean flag = false;
		a : for(int i=0;i<str.length();i++){
			if(str.charAt(i)>=48 && str.charAt(i)<=57 || ':' == str.charAt(i)){
				flag = true;
			str2+=str.charAt(i);
			}else {
				if(flag) {
					break a;
				}
			}
		}
		System.out.println(str2);
		SimpleDateFormat sDateFormat=new SimpleDateFormat("HH:mm:ss");
		try {
			Date date=sDateFormat.parse(str2);
			//48611000
			System.out.println(date.getTime());
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
