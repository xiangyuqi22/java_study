package windowbuilder.drag;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��6��27��
 * @author xiangning
 * @since JDK1.8
 */
import javax.swing.JFrame;
 
/**
 * ������ק������
 */
public class WinReSizeDemo {
    private JFrame jf;
    public WinReSizeDemo(){
        jf=new JFrame();
        jf.setUndecorated(true);//ȥ��߽�ͱ�����
        jf.setLocationRelativeTo(null);//��������
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ReSizeEvent dg = new ReSizeEvent(jf);
        /**�������������**/
        jf.addMouseListener(dg);
        jf.addMouseMotionListener(dg);
        jf.setVisible(true);
    }
    public static void main(String [] args){
        new WinReSizeDemo();
    }
}
