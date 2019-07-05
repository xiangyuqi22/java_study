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
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * ʵ�ִ��ڸ������������Լ��϶���
 */
public class ReSizeEvent extends MouseAdapter{
    public JFrame jf;
    private Point prePos,curPos,jfPos;
    private static final double BREADTH = 15.0;//�߽����췶Χ
    private  int dragType;
    private static final int DRAG_MOVE = 1;
    private static final int DRAG_UP = 2;
    private static final int DRAG_UPLEFT = 3;
    private static final int DRAG_UPRIGHT = 4;
    private static final int DRAG_LEFT = 5;
    private static final int DRAG_RIGHT = 6;
    private static final int DRAG_BOTTOM = 7;
    private static final int DRAG_BOTTOMLEFT = 8;
    private static final int DRAG_BOTTOMRIGHT = 9;
    public ReSizeEvent(JFrame jf){
        this.jf = jf;
    }
    @Override
    public void mousePressed(MouseEvent e){
        prePos = e.getLocationOnScreen();
    }
    @Override
    public void mouseMoved(MouseEvent e){
        areaCheck(e.getPoint());
    }
    @Override
    public void mouseDragged(MouseEvent e){
        curPos = e.getLocationOnScreen();
        jfPos = jf.getLocation();
        dragAction();
        prePos = curPos;
    }
    private void dragAction(){
        switch(dragType){
            case DRAG_MOVE:
                jf.setLocation(jfPos.x+curPos.x-prePos.x,
                        jfPos.y+curPos.y-prePos.y);
                break;
            case DRAG_UP://xλ�ò��䣬yλ�ñ仯������Height�仯
                jf.setLocation(jfPos.x,
                        jfPos.y+curPos.y-prePos.y);
                jf.setSize(jf.getWidth(), jf.getHeight()-(curPos.y-prePos.y));
                break;
            case DRAG_LEFT://yλ�ò��䣬xλ�ñ仯��width�仯
                jf.setLocation(jfPos.x+curPos.x-prePos.x,
                        jfPos.y);
                jf.setSize(jf.getWidth()-(curPos.x-prePos.x), jf.getHeight());
                break;
            case DRAG_RIGHT://x,yλ�ò��䣬width�仯
                jf.setLocation(jfPos.x,
                        jfPos.y);
                jf.setSize(jf.getWidth()+(curPos.x-prePos.x), jf.getHeight());
                break;
            case DRAG_BOTTOM://x,yλ�ò��䣬Height�仯
                jf.setLocation(jfPos.x,
                        jfPos.y);
                jf.setSize(jf.getWidth(), jf.getHeight()+(curPos.y-prePos.y));
                break;
            case DRAG_UPLEFT://x,yλ�þ��仯��h,w���仯
                jf.setLocation(jfPos.x+curPos.x-prePos.x,
                        jfPos.y+curPos.y-prePos.y);
                jf.setSize(jf.getWidth()-(curPos.x-prePos.x), jf.getHeight()-(curPos.y-prePos.y));
                break;
            case DRAG_BOTTOMRIGHT://x,yλ�þ����䣬h,w�仯
                jf.setLocation(jfPos.x,
                        jfPos.y);
                jf.setSize(jf.getWidth()+(curPos.x-prePos.x), jf.getHeight()+(curPos.y-prePos.y));
                break;
            case DRAG_UPRIGHT://xλ�ò��䣬y,w,h�仯
                jf.setLocation(jfPos.x,
                        jfPos.y+curPos.y-prePos.y);
                jf.setSize(jf.getWidth()+(curPos.x-prePos.x), jf.getHeight()-(curPos.y-prePos.y));
                break;
            case DRAG_BOTTOMLEFT://y���䣬xwh�仯
                jf.setLocation(jfPos.x+curPos.x-prePos.x,
                        jfPos.y);
                jf.setSize(jf.getWidth()-(curPos.x-prePos.x), jf.getHeight()+(curPos.y-prePos.y));
                break;
            default:
                break;
        }
    }
    private boolean areaCheck(Point p){
        if(p.getX()<=BREADTH && p.getY()<=BREADTH){
            dragType = DRAG_UPLEFT;
            jf.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
        }else if(p.getX()>BREADTH
                && p.getX()<(jf.getWidth()-BREADTH)
                && p.getY()<=BREADTH){
            dragType = DRAG_UP;
            jf.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
        }else if(p.getX()>=(jf.getWidth()-BREADTH) && p.getY()<=BREADTH){
            dragType = DRAG_UPRIGHT;
            jf.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
        }else if(p.getX()<=BREADTH
                && p.getY()<(jf.getHeight()-BREADTH)
                && p.getY()>BREADTH){
            dragType = DRAG_LEFT;
            jf.setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
        }else if(p.getX()>=(jf.getWidth()-BREADTH)
                && p.getY()<(jf.getHeight()-BREADTH)
                && p.getY()>BREADTH){
            dragType = DRAG_RIGHT;
            jf.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
        }else if(p.getX()<=BREADTH
                && p.getY()>=(jf.getHeight()-BREADTH)){
            dragType = DRAG_BOTTOMLEFT;
            jf.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
        }else if(p.getX()>BREADTH
                && p.getX()<(jf.getWidth()-BREADTH)
                && p.getY()>=(jf.getHeight()-BREADTH)){
            dragType = DRAG_BOTTOM;
            jf.setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
        }else if(p.getX()>=(jf.getWidth()-BREADTH)
                && p.getY()>=(jf.getHeight()-BREADTH)){
            dragType = DRAG_BOTTOMRIGHT;
            jf.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
        }else{
            dragType = DRAG_MOVE;
            jf.setCursor(new Cursor(Cursor.MOVE_CURSOR));
            return false;
        }
        return true;
    }
}
