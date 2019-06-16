package other.basic.system;

import java.lang.reflect.Field;

import windowbuilder.checkboxlist.main;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��1��10��
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

