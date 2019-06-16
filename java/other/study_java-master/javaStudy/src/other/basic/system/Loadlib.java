package other.basic.system;

import java.lang.reflect.Field;

import windowbuilder.checkboxlist.main;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年1月10日
 * @author xiangning
 * @since JDK1.8
 */
public class Loadlib {
	
	public static void main(String[] args) {
		System.out.println(System.getenv());
		try {
			String path = Loadlib.class.getResource("local.txt").getPath();
			System.out.println(path);
			addLibraryDir(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.getenv();
		System.out.println(System.getenv());
	}
	
	private static void addLibraryDir(String libraryPath) throws Exception {
	    Field userPathsField = ClassLoader.class.getDeclaredField("usr_paths");
	    userPathsField.setAccessible(true);
	    String[] paths = (String[]) userPathsField.get(null);
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < paths.length; i++) {
	        if (libraryPath.equals(paths[i])) {
	            continue;
	        }
	        sb.append(paths[i]).append(';');
	    }
	    sb.append(libraryPath);
	    System.setProperty("java.library.path", sb.toString());
	    final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
	    sysPathsField.setAccessible(true);
	    sysPathsField.set(null, null);
	}	

}

