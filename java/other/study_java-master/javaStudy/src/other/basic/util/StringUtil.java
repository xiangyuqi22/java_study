package other.basic.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月30日
 * @author xiangning
 * @since JDK1.8
 */
public class StringUtil {
	
//	public static <T> T[] getArray(Collection<? extends T> t , Class cla) {
//		List<T> collect = t.stream().map(s -> {
//			return Va
//			return s;
//		}).collect(Collectors.toList());
////		T[] array = collect.toArray(new T[collect.size()]);
//		collect.
//		return array;
//	}
	
	
	public static Long[] getLongArray(Collection<String> c) {
		
		List<Long> list = c.stream().map(s -> {
			Long long1 = null;
			try {
				long1 = Long.parseLong(s.trim());
			} catch (NumberFormatException e) {
				System.out.println("转换失败");
			}
			return long1;
		}).collect(Collectors.toList());
		Long[] longs = list.toArray(new Long[list.size()]);
		return longs;
	}
	
	/**
	 * getLongArray2:(将list里面的字符串转换成数值数组，支持转换成Integer Long)
	 * @author xiangning
	 *
	 * @param c
	 * @param t
	 * @return 返回数组，如果转换失败，则数组中的数据为NULL
	 */
	public static <T> T[] getLongArray2(Collection<String> c , 	T[] t) {
		List<T> list = getList1(c, t , true);
		return list.toArray(t);
	}
	
	/**
	 * getLongArrayNotNull:(同上方法，唯一不同的是如果转换失败，该数据将不会在数据里面返回)
	 * @author xiangning
	 *
	 * @param c
	 * @param t
	 * @return
	 */
	public static <T> T[] getLongArrayNotNull(Collection<String> c , 	T[] t) {
		List<T> list = getList1(c, t , false);
		T[] copyOf = Arrays.copyOf(t, list.size());
		return list.toArray(copyOf);
	}

	
	
	protected static <T> List<T> getList1(Collection<String> c, T[] t , boolean flag) {
		List<T> list = (List<T>) c.stream().map(s -> {
			try {
				if(t.getClass().getSimpleName().contains(Integer.class.getSimpleName())) {
					return Integer.valueOf(s);
				}else if(t.getClass().getSimpleName().contains(Long.class.getSimpleName())) {
					return Long.valueOf(s);
				}
			} catch (Exception e) {
				System.out.println("类型转换失败");
			}
			return null;
		}).collect(Collectors.toList());
		if ( !flag ) {
			Iterator<T> iterator = list.iterator();
			while (iterator.hasNext()) {
				T next = iterator.next();
				if(next == null ) {
					iterator.remove();
				}
			}
		}
		return list;
	}
	
	
	
	
	
	/**
	 * 判断字符串不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkStr(String str) {
		boolean bool = true;
		if (str == null || "".equals(str.trim()))
			bool = false;
		return bool;
	}
	/**
	 * checkList:(检查list是否为空)
	 * @author zhongjie
	 *
	 * @param list
	 * @return
	 */
	public static boolean checkList(List list) {
		boolean bool = true;
		if(list == null || list.size() == 0) {
			bool = false;
		}
		return bool;
	}
	
	/**
	 * getListElement:(从集合中获取对象，如果超出list索引，则返回null)
	 * @author xiangning
	 *
	 * @param list
	 * @param index
	 * @return
	 */
	public static <T>T getListElement(List<T> list , int index){
		if( index  >= list.size() ) {
			return null;
		}
		return list.get(index);
	}
	
	
	/**
	 * 判断对象不为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean checkObj(Object obj) {
		boolean bool = true;
		if (obj == null || "".equals(obj.toString().trim()))
			bool = false;
		return bool;
	}

	/**
	 * 返回对象不为空的toString方法 使用场景？
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		return obj != null ? obj.toString().trim() : "";
	}

	/**
	 * 对象转数值 String s = "20"; toInteger(s); // 20; Man man = new Man();
	 * man.toString(); // "15" toInteger(man); // 15
	 * 
	 * @param obj
	 * @return
	 */
	public static Integer toInteger(Object obj) {
		return obj != null ? Integer.parseInt(obj.toString()) : 0;
	}

	/**
	 * 字符串转数值，如果字符串为空，则返回-1； String s = ""; toInt(s); // -1
	 * 
	 * @param str
	 * @return
	 */
	public static int toInt(String str) {
		if("null".equals(str)) {
			return 0;
		}
		if(!isIntNumber(str)) {
			System.out.println("数值【" + str + "】不是int型" );
			return -1;
		}
		try {
			return "".equals(str) ? -1 : Integer.parseInt(str);
		} catch (Exception e) {
			System.out.println("数值【" + str + "】不能转换int型" );
			return -1;
		}
		
	}
	
	/**
	 * 字符串转数值，如果字符串为空，则返回-1； String s = ""; toLong(s); // -1
	 * 
	 * @param str
	 * @return
	 */
	public static long toLong(String str) {
		if(!isNum(str)) {
			System.out.println("【" + str + "】不是一个数值" );
			return -1;
		}
		try {
			return "".equals(str) ? -1 : Long.valueOf(str);
		} catch (Exception e) {
			System.out.println("数值【" + str + "】不能转换long型" );
			return -1;
		}
		
	}
	
	
	/**
	 * isNumber:(判断一个字符串是否为整型，int 非浮点类型)
	 * @author xiangning
	 *
	 * @param str
	 * @return
	 */
	public static boolean isIntNumber(String str) {
		if(str.startsWith("-")) {
			str = str.substring(1, str.length());
		}
		if (null == str || str.length() == 0) {
			return false;
		}

		for (int i = str.length(); --i >= 0;) {
			int c = str.charAt(i);
			if (c < 48 || c > 57) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 字符串编码从ISO8859_1转成GBK
	 * 
	 * @param str
	 * @return
	 */
	public static String getISOToGBK(String str) {
		String strName = "";
		try {
			if (str != null) {
				strName = new String(str.getBytes("ISO8859_1"), "GBK");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strName;
	}

	/**
	 * 字符串编码从ISO8859_1转成UTF8
	 * 
	 * @param str
	 * @return
	 */
	public static String getISOToUTF8(String str) {
		String strName = "";
		try {
			if (str != null) {
				strName = new String(str.getBytes("ISO8859_1"), "UTF8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strName;
	}

	/**
	 * 返回当前时间的yyyy-MM-dd格式字符串
	 * 
	 * @return str
	 */
	public static String getNowDate() {
		Date nowDate = new Date();
		Calendar now = Calendar.getInstance();
		now.setTime(nowDate);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = formatter.format(now.getTime());
		// str=getNextDate(str,-1);
		return str;
	}

	/**
	 * 返回指定时间的yyyy/MM/dd hh:mm:ss格式字符串
	 * 
	 * @return str
	 */
	public static String getDate(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String str = formatter.format(now.getTime());
		return str;
	}
	/**
	 * 返回指定时间的yyyy-MM-dd HH:mm:ss格式字符串
	 * 
	 * @return str
	 */
	public static String getDate2(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = formatter.format(now.getTime());
		return str;
	}

	/**
	 * 将null转换成空字符串
	 */
	public static String getNoNullString(String str) {
		if ("null".equals(str)) {
			return "";
		}
		return str;
	}

	/**
	 * 当前时间减去 30 天
	 * 
	 * @return
	 */
	public static String getNowTimeLittleDate2() {
		Calendar c = Calendar.getInstance();
		c.add(c.DATE, -30);
		String time = "" + c.get(c.YEAR) + "-" + (c.get(c.MONTH) + 1) + "-" + c.get(c.DATE) + " " + c.get(c.HOUR_OF_DAY)
				+ ":" + c.get(c.MINUTE) + ":" + c.get(c.SECOND);
		String returnstr = "";
		try {
			Date d = StringUtil.parses(time, "yyyy-MM-dd HH:mm:ss");
			// System.out.println(SimpleDateFormat(d,"yyyy-MM-dd HH:mm:ss"));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			returnstr = formatter.format(d);
		} catch (Exception e) {

		}
		return returnstr;
	}

	/**
	 * 返回当前时间的yyyy-MM-dd HH:mm:ss格式字符串
	 * 
	 * @return str
	 */
	public static String getNowTime() {
		Date nowDate = new Date();
		Calendar now = Calendar.getInstance();
		now.setTime(nowDate);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = formatter.format(now.getTime());
		return str;
	}
	
	
	/**
	 * 返回指定格式的当前时间
	 * 
	 * @return str
	 */
	public static String getNowTime(String format) {
		Date nowDate = new Date();
		Calendar now = Calendar.getInstance();
		now.setTime(nowDate);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String str = formatter.format(now.getTime());
		return str;
	}
	
	/**
	 * 可用于生成的文件夹命令
	 * 返回当前时间的yyyyMMdd格式字符串
	 * 
	 * @return str
	 */
	public static String getNowTime2() {
		Date nowDate = new Date();
		Calendar now = Calendar.getInstance();
		now.setTime(nowDate);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String str = formatter.format(now.getTime());
		return str;
	}
	/**
	 * 获取当前时间的年月日时分秒  用来生成文件名时用
	 * 
	 * @return str
	 */
	public static String getNowTime3() {
		Date nowDate = new Date();
		Calendar now = Calendar.getInstance();
		now.setTime(nowDate);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = formatter.format(now.getTime());
		return str;
	}
	
	/**
	 * getTime:(优先从NTP获取时间，NTP时间获取不到的话，再从本地系统获取时间)
	 * @author xiangning
	 *
	 * @param count	从NTP获取时间的请求次数
	 * @param format	返回的时间字符串格式
	 * @return
	 */
	public static String getTime(int count , String format) {
		return StringUtil.getNowTime(format);
	}
	
	
	/**
	 * getDateByString:(从字符串中提取时间)
	 * @author xiangning
	 *
	 * @param str	只能识别字符串中第一次出现数字，如"str20190210str201802"，只能截取识别到20190210
	 * @param format
	 * @return
	 */
	public static Date getDateByString(String str,String format) {
		/**
		 * 1：从字符串中提取数字
		 * 2：将数字格式化成日期
		 */
		String str2 = getTimeStringByStr(str,null);
		SimpleDateFormat sDateFormat=new SimpleDateFormat(format);
		Date date =  new Date();
		try {
			date = sDateFormat.parse(str2);
		} catch (ParseException e) {
			System.out.println("时间解析异常");
		}
		return date;
	}
	
	
	/**
	 * getTimeStringByStr:(从字符串中提取到时间)
	 * @author xiangning
	 *
	 * @param str		含有时间信息的字符串  如 《世界时间12:22:33世界》如果含有多个符合时间格式的字段，就会随机获取其中 一个
	 * @param separator	时间的分隔符  如《:》
	 * @return
	 */
	public static String getTimeStringByStr(String str,String separator) {
		
		if(StringUtil.checkStr(separator)) {
			Map<Integer,String> map = new HashMap<Integer,String>();
			Integer count = 0;
			for (int i = 0; i < str.length(); i++) {
				boolean bool = false;
				char charAtStr = str.charAt(i);
				bool = charAtStr >=48 && charAtStr <= 57 || separator.toCharArray()[0] == charAtStr;
				if(bool) {
					String words = String.valueOf(charAtStr);
					if(map.containsKey(count)) {
						map.put(count, map.get(count) + words);
					}else {
						map.put(count, words);
					}
				}else {
					count++;
				}
			}
			for (Entry<Integer, String> entry: map.entrySet()) {
				String value = entry.getValue();
				if(value.indexOf(separator) != -1) {
					String[] values = value.split(separator);
					try {
						if(toInt(values[0]) < 24 && toInt(values[1]) < 60) {
							str = entry.getValue();
						}
					} catch (Exception e) {
					}
				}
			}
		}
		
		String str2 = "";
		boolean flag = false;
		a : for(int i=0;i<str.length();i++){
			boolean bool = false;
			char charAtStr = str.charAt(i);
			if(StringUtil.checkStr(separator)) {
				bool = charAtStr >=48 && charAtStr <= 57 || separator.toCharArray()[0] == charAtStr;
			}else {
				bool = charAtStr >=48 && charAtStr <= 57 ;
			}
			
			if(bool){
				flag = true;
			str2+=str.charAt(i);
			}else {
				if(flag) {
					break a;
				}
			}
		}
		if(StringUtil.checkStr(separator)) {
			while(str2.startsWith(separator)) {
				str2 = str2.substring(1, str2.length());
			}
		}
		return str2;
	}
	
	/**
	 * getNumberForString:(从字符串中获取数字，只获取首次出现的数值，后面出现的不获取)
	 * @author xiangning
	 *
	 * @param str
	 * @return
	 */
	public static Integer getNumberForString(String str) {
		if(!str.matches("^.*\\d+.*$")) {
			return null;
		}
		String str2 = "";
		boolean flag = false;
		a : for (int i = 0; i < str.length(); i++) {
			boolean bool = false;
			char charAtStr = str.charAt(i);
			bool = charAtStr >=48 && charAtStr <= 57;
			if(bool) {
				flag = true;
				str2 += String.valueOf(charAtStr);
			}else {
				if(flag) {
					break a;
				}
			}
		}
		if(isNum(str2)) {
			return toInteger(str2);
		}
		return null;
	}
	
	
	/**
	 * getTimeNumber:(从日期中获取时间的值)
	 * @author xiangning
	 *
	 * @param date		日期时间	
	 * yyyyMMddHHmmss
	 * @param format	格式如 HH 小时  yyyy 年  等
	 * @return
	 */
	public static int getTimeNumber(Date date , String format) {
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		 String str = simpleDateFormat.format(date);
		 return toInt(str);
	}
	

	/**
	 * 返回两个时间的毫秒差值
	 * 
	 * @param sDate
	 * @param eDate
	 * @return long
	 */
	public static long getTimeInMillis(String sDate, String eDate) {
		Timestamp sd = Timestamp.valueOf(sDate);
		Timestamp ed = Timestamp.valueOf(eDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sd);
		long timethis = calendar.getTimeInMillis();

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(ed);
		long timeend = calendar2.getTimeInMillis();
		long thedaymillis = timeend - timethis;
		return thedaymillis;
	}

	/**
	 * 将给定的时间字符串格式化为yyyy-MM-dd HH:mm格式的字符串
	 * 
	 * @param dTime
	 * @return str
	 */
	public static String formatDateTime(String dTime) {
		String dateTime = "";
		if (dTime != null && !"".equals(dTime) && !dTime.startsWith("1900-01-01")) {
			Timestamp t = Timestamp.valueOf(dTime);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			dateTime = formatter.format(t);
		}
		return dateTime;
	}

	/**
	 * 将给定的时间字符串格式化为HH:mm:ss格式的字符串
	 * 
	 * @param dTime
	 * @return str
	 */
	public static String formatTime(String dTime) {
		String dateTime = "";
		if (dTime != null && !"".equals(dTime)) {
			Timestamp t = Timestamp.valueOf(dTime);
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
			dateTime = formatter.format(t);
		}
		return dateTime;
	}

	/**
	 * 按给定格式解析字符串为时间对象
	 * 
	 * @param strDate
	 * @param pattern
	 * @return Date
	 * @throws ParseException
	 */
	public static Date parses(String strDate, String pattern) throws ParseException {
		return new SimpleDateFormat(pattern).parse(strDate);
	}
	
	/**
	 * checkFile:(检查文件是否存在)
	 * @author xiangning
	 *
	 * @param file
	 * @return
	 */
	public static boolean checkFile(File file) {
		if(file != null && file.exists()) {
			return true;
		}
		return false;
	}

	/**
	 * 当前日期是第几周
	 * 
	 * @return str
	 */
	public static String getWeekOfYear() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String week = calendar.get(Calendar.WEEK_OF_YEAR) + "";
		return week;
	}

	/**
	 * 当前时间减去一年 返回yyyy-MM-dd HH:mm:ss格式字符串
	 * 
	 * @return str
	 */
	public static String getNowTimeLittle() {
		Calendar c = Calendar.getInstance();
		c.add(c.YEAR, +1);
		String time = "" + c.get(c.YEAR) + "-" + (c.get(c.MONTH) + 1) + "-" + c.get(c.DATE) + " " + c.get(c.HOUR_OF_DAY)
				+ ":" + c.get(c.MINUTE) + ":" + c.get(c.SECOND);
		String returnstr = "";
		try {
			Date d = StringUtil.parses(time, "yyyy-MM-dd HH:mm:ss");
			// System.out.println(SimpleDateFormat(d,"yyyy-MM-dd HH:mm:ss"));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			returnstr = formatter.format(d);
		} catch (Exception e) {
		}
		return returnstr;
	}

	/**
	 * 当前时间减去一天,返回yyyy-MM-dd 00:00:00格式字符串
	 * 
	 * @return str
	 */
	public static String getNowTimeLittleDate() {
		Calendar c = Calendar.getInstance();
		c.add(c.DATE, +1);
		String time = "" + c.get(c.YEAR) + "-" + (c.get(c.MONTH) + 1) + "-" + c.get(c.DATE) + " " + c.get(c.HOUR_OF_DAY)
				+ ":" + c.get(c.MINUTE) + ":" + c.get(c.SECOND);
		String returnstr = "";
		try {
			Date d = StringUtil.parses(time, "yyyy-MM-dd HH:mm:ss");
			// System.out.println(SimpleDateFormat(d,"yyyy-MM-dd HH:mm:ss"));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			returnstr = formatter.format(d);
		} catch (Exception e) {

		}
		return returnstr;
	}

	/**
	 * 根据参数获取随机值的整位数
	 * 
	 * @param num
	 * @return str
	 */
	public static String getRandom(int num) {
		return (Math.random() + "").substring(2, num + 2);
	}

	/**
	 * 返回两个时间的差值,小于秒用毫秒做单位
	 * 
	 * @param sDate
	 * @param eDate
	 * @return str
	 */
	public static String getTimeInMillis(Date sDate, Date eDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sDate);
		long timethis = calendar.getTimeInMillis();

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(eDate);
		long timeend = calendar2.getTimeInMillis();
		long thedaymillis = timeend - timethis;
		return thedaymillis < 1000 ? thedaymillis + "毫秒!" : (thedaymillis / 1000) + "秒钟!";
	}
	
	/**
	 * getTimeInMillis:(返回两个时间的差值)
	 * @author xiangning
	 *
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	public static int getTimeInMillis2(Date sDate, Date eDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sDate);
		long timethis = calendar.getTimeInMillis();

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(eDate);
		long timeend = calendar2.getTimeInMillis();
		long thedaymillis = timeend - timethis;
		return (int)thedaymillis;
	}
	

	public static String showTrace() {
		StackTraceElement[] ste = new Throwable().getStackTrace();
		StringBuffer CallStack = new StringBuffer();

		for (int i = 1; i < ste.length; i++) {
			CallStack.append(ste[i].toString() + "\n");
			if (i > 4)
				break;
		}
		return CallStack.toString();
	}

	public static String checkTableDefKey(String[] key, String[] value, String name) {
		String str = "";
		for (int i = 0; i < key.length; i++) {
			if (name.equals(key[i])) {
				str = value[i];
				break;
			}
		}
		return str;
	}

	/**
	 * 判断字符串是否中文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		String regEx = "[\\u4e00-\\u9fa5]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.find();
	}

	public static String getStrToGbk(String str) {
		String strName = "";
		try {
			if (str != null) {
				strName = new String(str.getBytes("UTF-8"), "GBK");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strName;
	}

	public static String getNextDate(String ts, int i) {
		Calendar now = Calendar.getInstance();
		Timestamp t = Timestamp.valueOf(ts + " 00:00:00.000");
		now.setTime(t);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		now.add(Calendar.DAY_OF_MONTH, +(i));
		String dt = formatter.format(now.getTime());
		return dt;
	}

	/**
	 * 对时间的分钟部分进行加减操作，返回yyyy-MM-dd HH:mm:ss格式字符串
	 * 
	 * @param ts
	 * @param i
	 * @return
	 */
	public static String getNextTime(String ts, int i) {
		Calendar now = Calendar.getInstance();
		Timestamp t = Timestamp.valueOf(ts);
		now.setTime(t);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		now.add(Calendar.MINUTE, +(i));
		String dt = formatter.format(now.getTime());
		return dt;
	}

	/**
	 * 对时间的月份部分进行加减操作，返回yyyy-MM-dd HH:mm:ss格式字符串
	 * 
	 * @param ts
	 * @param i
	 * @return
	 */
	public static String getNextMonth(String ts, int i) {
		Calendar now = Calendar.getInstance();
		Timestamp t = Timestamp.valueOf(ts);
		now.setTime(t);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM-dd HH:mm:ss");
		now.add(Calendar.MONTH, +(i));
		String dt = formatter.format(now.getTime());
		return dt;
	}

	/**
	 * 取Unix时间戳
	 * 
	 * @param dateTime
	 * @return
	 */
	public static long getUnixTime(String dateTime) {
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime);
			date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1970-01-01 08:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long l = (date1.getTime() - date2.getTime()) / 1000;
		return l;
	}

	/**
	 * 字符串首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String toFirstUpperCase(String str) {
		if (str == null || "".equals(str.trim()))
			return "";
		String firstChar = str.substring(0, 1).toUpperCase();
		String lastStr = str.substring(1);
		return firstChar + lastStr;
	}
	
	//首字母转小写
	public static String toLowerCaseFirstOne(String s){
	  if(Character.isLowerCase(s.charAt(0)))
	    return s;
	  else
	    return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}



	/**
	 * 判断一个字符串是不是数字; 必须以-、+、数字或.号为开头，允许以数字或小数点结尾，但不能是null,空字符或仅仅只是.号 ;
	 * 总之就是Double.parseDouble转换不报异常即可; 如 -1.；.1；1.；-.123；1.1；-12.12； 都会返回true 。
	 * .1.；1 123；1-123；..1；1..；..；.； 都会返回false。
	 * 
	 * @param str
	 *            字符串
	 * @return 是数值返回true,否则false
	 */
	public static boolean isNum(String str) {
		boolean flg = false;

		if (str != null && (str = str.trim()).length() > 0) {
			String dbl = "((^(\\-|\\+)?([0-9]+)?(\\.)?)([0-9]+$))|((^(\\-|\\+)?([0-9]+)?)[0-9]+([0-9\\.]$))";
			flg = Pattern.compile(dbl).matcher(str).matches();
		}

		return flg;
	}

	/**
	 * 判断一个字符串是不是整数
	 * 
	 * @param str
	 *            字符串
	 * @return 是数值返回true,否则false
	 */
	public static boolean isInteger(String str) {
		str = str.trim();
		String integer = "[\\-\\+]?[0-9]+$";
		boolean flg = Pattern.compile(integer).matcher(str).matches();
		return flg;
	}

	/**
	 * 去除字符串数组中的重复值
	 * 
	 * @param stringArray
	 *            字符串数组
	 * @return 去重复的字符串数组
	 */
	public static String[] filterRepeat(String[] stringArray) {
		ArrayList<String> arrayList = new ArrayList<String>();
		for (String str : stringArray) {
			if (!arrayList.contains(str)) {
				arrayList.add(str);
			}
		}
		return (String[]) arrayList.toArray(new String[] {});
	}

	/**
	 * 得到ID的in字句 如e.id in (1,3,4)
	 * 
	 * @param ids
	 *            如"1,2,3,"等
	 * @param alias
	 *            如"e.id"等
	 * @return
	 */
	public static String getIn300Ids(String ids, String alias) {
		String tempS[] = ids.split(",");
		int len = tempS.length;
		int which = 0;
		boolean isAnd = alias.indexOf("not") > 0;
		StringBuffer idsStr = new StringBuffer();
		idsStr.append("(");
		if (len > 300) {
			if (len % 300 > 0) {
				which = len / 300 + 1;
			} else {
				which = len / 300;
			}
			for (int i = 0; i < which; i++) {
				idsStr.append(alias + " in (");
				for (int j = 300 * i; j < 300 * i + 300; j++) {
					if (j < len) {
						idsStr.append(tempS[j] + ",");
					} else {
						break;
					}
				}
				idsStr = idsStr.replace(idsStr.lastIndexOf(","), idsStr.length(), "");
				if (i < which - 1) {
					if (isAnd) {
						idsStr.append(") and ");
					} else {
						idsStr.append(") or ");
					}
				} else {
					idsStr.append(")");
				}
			}
		} else {
			idsStr.append(alias + " in (");
			if (ids.lastIndexOf(",") == ids.length() - 1) {
				idsStr.append(ids.substring(0, ids.length() - 1));
			} else {
				idsStr.append(ids);
			}
			idsStr.append(" )");
		}
		idsStr.append(")");
		return idsStr.toString();
	}

	/**
	 * 格式字符串 格式：a,b,v====>'a','b','v'
	 * 
	 * @param str
	 * @return
	 */
	public static String getFormatString(String str) {
		String strArr[] = str.split(",");
		String retStr = "";
		for (int i = 0; i < strArr.length; i++) {
			if (i > 0) {
				retStr = retStr + ",";
			}
			retStr = retStr + "'" + strArr[i] + "'";
		}
		return retStr;
	}

	public static String strRound(double value, int decimalPlaces) {
		// 声明一个返
		String rval;

		// 如果小数位是0
		if (decimalPlaces == 0) {
			rval = String.valueOf(Math.round(value));
			return rval;
		}

		// 先将参数值转为String型,并找到小数点所在位置
		DecimalFormat dformat = new DecimalFormat("0.0000000");
		String str = dformat.format(value);
		int point = str.indexOf(".");
		// 分别得到小数点之前的字符与小数点之后的字符
		String beforePoint = str.substring(0, point);
		String afterPoint = str.substring(point + 1);

		// 如果小数位正好是要求的小数位数
		if (afterPoint.length() == decimalPlaces) {
			rval = String.valueOf(value);
		} else if (afterPoint.length() < decimalPlaces) {
			// 如果小数位数少于要求的小数位数,则在后面补零
			StringBuffer sb = new StringBuffer(afterPoint);
			for (int i = 0; i < decimalPlaces - afterPoint.length(); i++) {
				sb.append("0");
			}
			// 连接
			sb.insert(0, ".").insert(0, beforePoint);
			rval = sb.toString();
		} else {
			// 如果小数位数多于要求的小数位数,则要四舍五入

			// 不管怎样,先舍
			StringBuffer sb = null;
			sb = new StringBuffer(beforePoint);
			sb.append(".").append(afterPoint.substring(0, decimalPlaces));
			String val = sb.toString();
			// 得到要舍掉的那位数
			int temp = Integer.valueOf(afterPoint.charAt(decimalPlaces) + "");
			// 如果要舍掉位置的数<4
			if (temp < 4) {
				rval = val;
			} else {
				// 如果要舍掉的位置>4

				// 构造出要加的o.XX1,如期而至2.588,保留2位小数,就要在2.5的基础上加0.01
				sb = new StringBuffer("0.1");
				for (int i = 1; i < decimalPlaces; i++) {
					sb.insert(2, "0");
				}

				// 在已经舍掉的情况下加上该补足的0.XX1
				double dbl = Double.valueOf(val) + Double.valueOf(sb.toString());
				val = String.valueOf(dbl);
				// 此时加完后可能变成1,如0.99,保留1位小数,四舍五入就变成1了,所以要再判断是否小数位够位数
				// 如果没有小数位,则补足小数位
				if (val.indexOf(".") == -1) {
					val += ".";
					for (int i = 0; i < decimalPlaces; i++) {
						val += "0";
					}

					rval = val;
				} else {
					// 如果有小数位,不管怎样都补足小数位
					val = val.substring(val.indexOf(".") + 1);
					sb = new StringBuffer(dbl + "");
					for (int i = 0; i < decimalPlaces - val.length(); i++) {
						sb.append("0");
					}
					rval = sb.toString();
				}
			}
		}

		// 因为double型不精确,所以最后再截一次
		point = rval.indexOf(".");
		return rval.substring(0, point + decimalPlaces + 1);

	}

	/**
	 * 删除input字符串中的html格式
	 * 
	 * @param input
	 * @return
	 */
	public static String splitAndFilterString(String input) {
		if (input == null || input.trim().equals("")) {
			return "";
		}
		// 去掉所有html元素,
		String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
		// String str = input.replaceAll("<[a-zA-Z]+[1-9]?[^><]*>",
		// "").replaceAll("</[a-zA-Z]+[1-9]?>", "");
		str = str.replaceAll("[(/>)<]", "");
		return str;
	}

	/**
	 * 返回数据库数据类型的编号
	 * 
	 * @param typeName
	 * @param colScale
	 * @return
	 */
	public static int getColType(String typeName, String colScale) {
		int type = 0;
		if ("varchar".equalsIgnoreCase(typeName) || "varchar2".equalsIgnoreCase(typeName)
				|| "text".equalsIgnoreCase(typeName)) {
			type = 1;
		} else if ("char".equalsIgnoreCase(typeName)) {
			type = 2;
		} else if ("datetime".equalsIgnoreCase(typeName)) {
			type = 6;
		} else if ("date".equalsIgnoreCase(typeName)) {
			type = 7;
		} else if ("time".equalsIgnoreCase(typeName)) {
			type = 8;
		}

		if (Integer.parseInt(colScale) > 0) {
			type = 5;
		} else {
			if ("numeric".equalsIgnoreCase(typeName) || "long".equalsIgnoreCase(typeName)) {
				type = 3;
			} else if ("smallint".equalsIgnoreCase(typeName) || "int".equalsIgnoreCase(typeName)
					|| "integer".equalsIgnoreCase(typeName)) {
				type = 4;
			}
		}
		return type;
	}

	public static String getDBDefault(int type, String def) {
		String deft = "";
		if (def != null && !"".equals(def)) {
			if (type == 1 || type == 2 || type == 6 || type == 7 || type == 8)
				deft = "default " + def;
			else
				deft = "default '" + def + "'";
		}
		return deft;
	}

	/**
	 * 获取数据库数据类型
	 * 
	 * @param type
	 * @param len
	 * @param flt
	 * @return
	 */
	public static String getDBColType(int type, int len, int flt) {
		String typeName = "";
		if (type == 1) {
			typeName = "varchar(" + len + ")";
		} else if (type == 2) {
			typeName = "char(" + len + ")";
		} else if (type == 3) {
			typeName = "numeric(" + len + ")";
		} else if (type == 4) {
			typeName = "int";
		} else if (type == 5) {
			typeName = "numeric(" + len + "," + flt + ")";
		} else if (type == 6) {
			typeName = "datetime";
		} else if (type == 7) {
			typeName = "date";
		} else if (type == 8) {
			typeName = "time";
		}
		return typeName;
	}

	/**
	 * 获取java数据类型
	 * 
	 * @param type
	 * @return
	 */
	public static String getStrColType(int type) {
		String typeName = "";
		if (type == 1) {
			typeName = "String";
		} else if (type == 2) {
			typeName = "Char";
		} else if (type == 3) {
			typeName = "Long";
		} else if (type == 4) {
			typeName = "Integer";
		} else if (type == 5) {
			typeName = "Double";
		} else if (type == 6) {
			typeName = "Date";
		} else if (type == 7) {
			typeName = "Date";
		} else if (type == 8) {
			typeName = "Date";
		}
		return typeName;
	}

	/**
	 * 获取htc列表排序字段数据类型
	 * 
	 * @param type
	 * @return
	 */
	public static String getGridColType(int type) {
		String typeName = "";
		if (type == 1) {
			typeName = "String";
		} else if (type == 2) {
			typeName = "String";
		} else if (type == 3) {
			typeName = "Number";
		} else if (type == 4) {
			typeName = "Number";
		} else if (type == 5) {
			typeName = "Number";
		} else if (type == 6) {
			typeName = "Date";
		} else if (type == 7) {
			typeName = "Date";
		} else if (type == 8) {
			typeName = "Date";
		}
		return typeName;
	}

	/**
	 * 获取字符串的中文个数
	 * 
	 * @author tanjianwen
	 * @return 中文个数
	 */
	public static int getChineseCount(String str) {
		return str.getBytes().length - str.length();
	}

	/**
	 * 截取带中文字符串的方法(中文占2个字符)
	 * 
	 * @author tanjianwen
	 * @param 字符串
	 * @param 截取起始位置
	 * @param 截取长度
	 * @return 结果字符串
	 */
	public static String getSubString(String str, int pstart, int pend) {
		if (str == null || str.length() == 0)
			return "";
		String resu = "";
		int beg = 0;
		int end = 0;
		int count1 = 0;
		char[] temp = new char[str.length()];
		str.getChars(0, str.length(), temp, 0);
		boolean[] bol = new boolean[str.length()];
		for (int i = 0; i < temp.length; i++) {
			bol[i] = false;
			if ((int) temp[i] > 255) {// 说明是中文
				count1++;
				bol[i] = true;
			}
		}

		if (pstart > str.length() + count1) {
			resu = null;
		}
		if (pstart > pend) {
			resu = null;
		}
		if (pstart < 1) {
			beg = 0;
		} else {
			beg = pstart - 1;
		}
		if (pend > str.length() + count1) {
			end = str.length() + count1;
		} else {
			end = pend;// 在substring的末尾一样
		}
		// 下面开始求应该返回的字符串
		if (resu != null) {
			if (beg == end) {
				int count = 0;
				if (beg == 0) {
					if (bol[0] == true)
						resu = null;
					else
						resu = new String(temp, 0, 1);
				} else {
					int len = beg;// zheli
					for (int y = 0; y < len; y++) {// 表示他前面是否有中文,不管自己
						if (bol[y] == true)
							count++;
						len--;// 想明白为什么len--
					}
					// for循环运行完毕后，len的值就代表在正常字符串中，目标beg的上一字符的索引值
					if (count == 0) {// 说明前面没有中文
						if ((int) temp[beg] > 255)// 说明自己是中文
							resu = null;// 返回空
						else
							resu = new String(temp, beg, 1);
					} else {// 前面有中文，那么一个中文应与2个字符相对
						if ((int) temp[len + 1] > 255)// 说明自己是中文
							resu = null;// 返回空
						else
							resu = new String(temp, len + 1, 1);
					}
				}
			} else {// 下面是正常情况下的比较
				int temSt = beg;
				int temEd = end - 1;// 这里减掉一
				for (int i = 0; i < temSt; i++) {
					if (bol[i] == true)
						temSt--;
				} // 循环完毕后temSt表示前字符的正常索引
				for (int j = 0; j < temEd; j++) {
					if (bol[j] == true)
						temEd--;
				} // 循环完毕后temEd-1表示最后字符的正常索引
				if (bol[temSt] == true)// 说明是字符，说明索引本身是汉字的后半部分，那么应该是不能取的
				{
					int cont = 0;
					for (int i = 0; i <= temSt; i++) {
						cont++;
						if (bol[i] == true)
							cont++;
					}
					if (pstart == cont)// 是偶数不应包含,如果pstart<cont则要包含
						temSt++;// 从下一位开始
				}
				if (bol[temEd] == true) {// 因为temEd表示substring
											// 的最面参数，此处是一个汉字，下面要确定是否应该含这个汉字
					int cont = 0;
					for (int i = 0; i <= temEd; i++) {
						cont++;
						if (bol[i] == true)
							cont++;
					}
					if (pend < cont)// 是汉字的前半部分不应包含
						temEd--;// 所以只取到前一个
				}
				if (temSt == temEd) {
					resu = new String(temp, temSt, 1);
				} else if (temSt > temEd) {
					resu = null;
				} else {
					resu = str.substring(temSt, temEd + 1);
				}
			}
		}
		return resu;// 返回结果
	}

	/**
	 * 判断请求IP是否包含在ip数组中
	 * 
	 * @param requestIP
	 *            当前IP
	 * @param ips
	 *            一组IP
	 * @return true包含;false不包含
	 */
	public static boolean checkIP(String requestIP, String[] ips) {
		for (String ip : ips) {
			if (requestIP.equals(ip))
				return true;
			if ((ip.indexOf("-")) >= 0) {// x.x.x.x-x.x.x.x
				String[] ipPart = requestIP.split("\\.");
				String[] ipOpenPart = ip.split("\\-")[0].split("\\.");
				String[] ipEndPart = ip.split("\\-")[1].split("\\.");
				if (ipOpenPart.length != ipPart.length || ipEndPart.length != ipPart.length)
					continue;
				boolean flag = true;
				for (int i = 0; i < ipPart.length; i++) {
					if (ipPart[i].compareTo(ipOpenPart[i]) < 0 || ipPart[i].compareTo(ipEndPart[i]) > 0) {
						flag = false;
					}
				}
				if (flag)
					return true;
			}
		}
		return false;
	}

	/**
	 * 效验字符串是否符合正则表达式格式
	 * 
	 * @param value
	 *            值
	 * @param regexp
	 *            表达式
	 * @return 是否符合要求
	 */
	public static boolean checkRegexp(String value, String regexp) {
		return Pattern.compile(regexp).matcher(value).matches();
	}

	/**
	 * 转数据类型，转完后的值，可用于SQL ？号入库
	 * 
	 * @param fieldType
	 *            1||NUMBER:浮点数(Double||BigDecimal); 2||DIGIT:
	 *            整数(Integer||Long||BigDecimal); 4||DATE: 日期,不含时分秒(Timestamp);
	 *            7||DATETIME：日期，包含时分秒(Timestamp); 5||STRING：文本串(String);
	 * @param value
	 *            被转换的值
	 * @return 转换好的值
	 */
	public static Object parseObj(String fieldType, String value) {
		return parseObj(fieldType, value, null, null);
	}

	/**
	 * 转数据类型，转完后的值，可用于SQL ？号入库
	 * 
	 * @param fieldType
	 *            1||NUMBER:浮点数(Double||BigDecimal); 2||DIGIT:
	 *            整数(Integer||Long||BigDecimal); 4||DATE:
	 *            默认返回年月日,配合format,flg参数使用,如果format,flg都为空，则返回一个不含时分秒的日期(Timestamp);
	 *            7||DATETIME：日期，包含时分秒(Timestamp);
	 *            8||TIMESTAMP：自定义年月日时分秒，由format参数决定(Timestamp);
	 *            3||5||6||STRING：文本串(String);
	 * @param value
	 *            被转换的值
	 * @param format
	 *            日期转换格式
	 * @param flg
	 *            是否在value后追加" 23:59:59"，配合fieldType=4使用 如果:flg!=false，会在value值后加
	 *            23:59:59，然后按format格式进行转换，format为空，则默认yyyy-MM-dd HH:mm:ss
	 *            使用场景：时间区间查询，结束时间若没有时分秒，则以一天最后一秒为准
	 *            否则:直接按format格式进行转换,format为空，则默认yyyy-MM-dd
	 * @return 转换好的值
	 */
	public static Object parseObj(String fieldType, String value, String format, Boolean flg) {
		Object obj = null;
		try {
			int ftype = getFiledType(fieldType);

			if (StringUtil.checkStr(value)) {
				switch (ftype) {
				case 2:
					obj = (value.length() >= 18) ? new BigDecimal(value) : toDigit(value);
					break;// 整数
				case 1:
					obj = (value.length() > 10) ? new BigDecimal(value) : Double.valueOf(value);
					break;// 小数
				case 4:
					obj = getSqlDate(value, format, flg);
					break;// 日期
				case 7:
					obj = getSqlDateTime(value, format);
					break;// 日期时间
				case 8:
					obj = getSqlDateTime(value, format);
					break;// 时间，以后扩展用到
				default:
					obj = value;
				}
			}
		} catch (Exception ex) {
			obj = value;
		}
		return obj;
	}

	/**
	 * 数据类型枚举文本转枚举值
	 * 
	 * @param fieldType
	 *            数据类型
	 * @return 类型值
	 */
	private static int getFiledType(String fieldType) {
		String type;
		if (isInteger(fieldType)) {
			type = fieldType;
		} else if ("NUMBER".equals(fieldType)) {
			type = "1";
		} else if ("DIGIT".equals(fieldType)) {
			type = "2";
		} else if ("DATE".equals(fieldType)) {
			type = "4";
		} else if ("DATETIME".equals(fieldType)) {
			type = "7";
		} else if ("TIMESTAMP".equals(fieldType)) {
			type = "8";
		} else {
			type = "5";
		}
		return toInt(type);
	}

	/**
	 * 转整型,大于10位转成Long,否则Integer
	 * 
	 * @param value
	 *            被转换的值
	 * @return 整数
	 */
	private static Object toDigit(String value) {
		return (value.length() >= 10) ? Long.valueOf(value) : StringUtil.toInt(value);
	}

	/**
	 * 日期类型
	 * 
	 * @param value
	 *            被转换的值
	 * @param format
	 *            日期转换格式
	 * @param flg
	 *            是否在value后追加" 23:59:59"
	 * @return 日期时间对象
	 * @throws Exception
	 */
	private static Timestamp getSqlDate(String value, String format, Boolean flg) throws Exception {
		String str;
		if (flg != null && flg == false) {
			str = StringUtil.checkStr(format) ? format : "yyyy-MM-dd";
		} else {
			value += " 23:59:59";
			str = StringUtil.checkStr(format) ? format : "yyyy-MM-dd HH:mm:ss";
		}
		return getSqlDateTime(value, str);
	}

	private static Timestamp getSqlDateTime(String value) throws Exception {
		return getSqlDateTime(value, null);
	}

	/**
	 * 按格式转成日期对象
	 * 
	 * @param value
	 *            被转换的值
	 * @param format
	 *            日期转换格式
	 * @return 日期时间对象
	 * @throws Exception
	 */
	private static Timestamp getSqlDateTime(String value, String format) throws Exception {
		String str = StringUtil.checkStr(format) ? format : "yyyy-MM-dd HH:mm:ss";
		Timestamp timestamp = null;
		try {
			str = StringUtil.checkStr(format) ? format : "yyyy-MM-dd HH:mm:ss";
			timestamp = new Timestamp(StringUtil.parses(value, str).getTime());
		} catch (Exception e) {
			str = "yyyy-MM-dd";
			timestamp = new Timestamp(StringUtil.parses(value, str).getTime());
		}
		return timestamp;
	}

	/**
	 * 获取IP地址
	 * 
	 * @return IP地址
	 */
	public static String getIPAddress() {
		String ip = null;
		try {
			String os = System.getProperty("os.name");
			ip = os.startsWith("Windows") ? getIPOnWindows() : getIPOnLinux();
		} catch (Exception e) {
		}

		return ip;
	}

	/**
	 * Windows下获取本机IP地址
	 * 
	 * @return IP地址
	 */
	private static String getIPOnWindows() throws Exception {
		String ip = "";
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("ipconfig");
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			int index = -1;
			boolean isLocal = false;
			while ((line = bufferedReader.readLine()) != null) {
				// 找到本地连接信息
				if (line.toLowerCase().indexOf("ethernet adapter 本地连接:") >= 0 || line.indexOf("以太网适配器 本地连接:") >= 0
						|| line.indexOf("以太网适配器 以太网:") >= 0) {
					isLocal = true;
				}

				// 找到IP信息
				if (line.toLowerCase().indexOf("ipv4") >= 0 || line.toLowerCase().indexOf("ip address") >= 0) {
					if (isLocal) {
						index = line.indexOf(":");
						ip = line.substring(index + 1).trim();
						break;
					}
				}
			}
			// 没有取到本地连接中的IP信息，则通过Java API来获取
			if (!StringUtil.checkStr(ip)) {
				InetAddress inet = InetAddress.getLocalHost();
				ip = inet.getHostAddress();
			}
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
			}
			bufferedReader = null;
			process = null;
		}

		return ip;
	}

	/**
	 * Linux下获取本机IP地址
	 * 
	 * @return IP地址
	 */
	private static String getIPOnLinux() throws Exception {
		String ip = "";
		try {
			Enumeration<?> e1 = (Enumeration<?>) NetworkInterface.getNetworkInterfaces();
			while (e1.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) e1.nextElement();
				if (!ni.getName().equals("eth0")) {
					continue;
				} else {
					Enumeration<?> e2 = ni.getInetAddresses();
					while (e2.hasMoreElements()) {
						InetAddress ia = (InetAddress) e2.nextElement();
						if (ia instanceof Inet6Address)
							continue;
						ip = ia.getHostAddress();
					}
					break;
				}
			}
		} catch (Exception e) {
		}

		return ip;
	}
	
	/**
	 * string2Unicode:(string转unicode)
	 * 
	 * @author xiangning
	 *
	 * @param string
	 * @return
	 */
	public static String string2Unicode(String string) {
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			// 取出每一个字符
			char c = string.charAt(i);
			// 转换为unicode
			unicode.append("\\u" + Integer.toHexString(c));
		}
		return unicode.toString();
	}
	
	/**
	 * getKeyFromMapByValue:(根据map的值 获取键)
	 * @author xiangning
	 *
	 * @param map
	 * @param value
	 * @return
	 */
	public static String getKeyFromMapByValue(Map<String,String> map,String value) {
		if(value == null) {
			return "";
		}
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if(value.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return "";
	}
	/**
	 * isHostConnectable:(测试链接地址是否可用)
	 * @author xiangning
	 *
	 * @param urlPath
	 * @return
	 */
	public static boolean isHostConnectable(String urlPath) {
		URL url;
		try {
			url = new URL(urlPath);
			URLConnection co =  url.openConnection();
			co.setConnectTimeout(500);
			co.connect();
		} catch (Exception e) {
			System.out.println("服务器配置连接失败 -> " + urlPath + ";" + e.getMessage());
			return false;
		}
		return true;
	}	
	
	
	/**
	 * 复制map对象
	 * @explain 将paramsMap中的键值对全部拷贝到resultMap中；
	 * paramsMap中的内容不会影响到resultMap（深拷贝）
	 * @param paramsMap
	 *     被拷贝对象
	 * @param resultMap
	 *     拷贝后的对象
	 */
	public static void mapCopy(Map paramsMap, Map resultMap, List list) {
	    if (resultMap == null) resultMap = new HashMap();
	    if (paramsMap == null) return;
	    Iterator it = paramsMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry entry = (Map.Entry) it.next();
	        Object key = entry.getKey();
	        if(StringUtil.checkList(list)) {
	        	boolean contains = list.contains(key);
	        	if(contains) {
	        		continue;
	        	}
	        }
	        Object value = paramsMap.get(key);
	        if(StringUtil.checkObj(value)) {
	        	resultMap.put(key, value);
	        }

	    }
	}
	
	/**
	 * getFileNameByPath:(获取文件名)
	 * @author xiangning
	 *
	 * @param filePath	文件路径
	 * @return
	 */
	public static String getFileNameByPath(String filePath) {
		if(checkStr(filePath)) {
			int index = filePath.lastIndexOf(File.separator);
			return filePath.substring(index + 1);
		}
		return null;
	}
	
	public static final int B = 0;//字节
	public static final int M = 1;//兆
	public static final int G = 2;//G
	/**
	 * turnByte:(将字节转换成兆或G)
	 * @author xiangning
	 *
	 * @return
	 */
	public static String turnByte(long  b ,  int type) {
		switch (type) {
			case B:
				return b + "byte";
			case M:
				return b / (1024 * 1024) + "M";
			case G:
				return b / (1024 * 1024 * 1024) + "G";
			default:
				return "";
			}
	}
	
	/**
	 * equals:(判断两个字符串是否相等，如果两个都为NULL，也是相等的)
	 * @author xiangning
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean equals( Object a , Object b ) {
		if( a == null && b == null ) {
			return true;
		}
		if( a == null || b == null ) {
			return false;
		}
		return a.equals(b);
	}
	
	/**
	 * 字符串转unicode
	 * 
	 * @param str
	 * @return
	 */
	public static String stringToUnicode(String str) {
		StringBuffer sb = new StringBuffer();
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			sb.append("\\u" + Integer.toHexString(c[i]));
		}
		return sb.toString();
	}
 
	/**
	 * unicode转字符串
	 * 
	 * @param unicode
	 * @return
	 */
	public static String unicodeToString(String unicode) {
		StringBuffer sb = new StringBuffer();
		String[] hex = unicode.split("\\\\u");
		for (int i = 1; i < hex.length; i++) {
			int index = Integer.parseInt(hex[i], 16);
			sb.append((char) index);
		}
		return sb.toString();

	}
	

}
