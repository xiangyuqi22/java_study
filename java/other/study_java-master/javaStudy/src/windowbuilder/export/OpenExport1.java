package windowbuilder.export;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��7��22��
 * @author xiangning
 * @since JDK1.8
 */
public class OpenExport1 {
	
	public static void main(String[] args) {
		if (java.awt.Desktop.isDesktopSupported()) {
			try {
				// ����һ��URIʵ��
				java.net.URI uri = java.net.URI.create("http://www.taobao.com");
				// ��ȡ��ǰϵͳ������չ
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				// �ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ���
				if (dp.isSupported(java.awt.Desktop.Action.BROWSE))  {
					// ��ȡϵͳĬ�������������
					dp.browse(uri);
				}
 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
