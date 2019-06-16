package windowbuilder.jpanel;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��14��
 * @author xiangning
 * @since JDK1.8
 */
public class JpanelSecond  extends JFrame {
	//����һ������
	Container ct;
	//����������塣
	BackgroundPanel bgp;
	
	//����һ����ť������֤�����ǵ�ȷ�Ǵ����˱���ͼƬ��������һ��ͼƬ��
	JButton jb;
	public static void main(String[] args)
	{
		new JpanelSecond();
	}
	public JpanelSecond()
	{
		//�������κβ��ַ�ʽ��
		ct=this.getContentPane();
		this.setLayout(null);
		
		//�����������һ��400*300����Ƭ�ȿ��Կ������Խ����
		bgp=new BackgroundPanel((new ImageIcon(JpanelSecond.class.getResource("login-background.png")).getImage()));
		bgp.setBounds(0,0,400,300);
		ct.add(bgp);
		
		//������ť
		jb=new JButton("���԰�ť");
		jb.setBounds(60,30,160,30);
		ct.add(jb);
		
		this.setSize(400,300);
		this.setLocation(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
class BackgroundPanel extends JPanel
{
	Image im;
	public BackgroundPanel(Image im)
	{
		this.im=im;
		this.setOpaque(true);
	}
	//Draw the back ground.
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
		
	}
}
