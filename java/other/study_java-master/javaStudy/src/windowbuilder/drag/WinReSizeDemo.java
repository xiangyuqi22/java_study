package windowbuilder.drag;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月27日
 * @author xiangning
 * @since JDK1.8
 */
import javax.swing.JFrame;
 
/**
 * 窗体拖拽和拉伸
 */
public class WinReSizeDemo {
    private JFrame jf;
    public WinReSizeDemo(){
        jf=new JFrame();
        jf.setUndecorated(true);//去标边界和标题栏
        jf.setLocationRelativeTo(null);//窗口置中
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ReSizeEvent dg = new ReSizeEvent(jf);
        /**添加两个监听器**/
        jf.addMouseListener(dg);
        jf.addMouseMotionListener(dg);
        jf.setVisible(true);
    }
    public static void main(String [] args){
        new WinReSizeDemo();
    }
}
