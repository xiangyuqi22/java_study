package windowbuilder.dialog;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;
 
public class JImagedPopupMenu extends JPopupMenu {
 
    private Font font = new Font("utf-8", Font.BOLD, 16);
    private ImageIcon imageIcon = null;
 
    public JImagedPopupMenu(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
    public JImagedPopupMenu(String text) {
        this.imageIcon = createImage(text);
    }
 
    private ImageIcon createImage(String text) {
        BufferedImage bi = new BufferedImage(30, 100, BufferedImage.TYPE_INT_ARGB);
        ImageIcon image = new ImageIcon(bi);
        Graphics2D g2d = bi.createGraphics();
 
        GradientPaint paint = new GradientPaint(0, 0, Color.green.darker(), 
                30, 10, Color.yellow.brighter(), true);
        g2d.setPaint(paint);
 
        g2d.fillRect(0, 0, bi.getWidth(), bi.getHeight());
 
        AffineTransform at = new AffineTransform();
        at.rotate(-Math.PI / 2);
 
        g2d.setTransform(at);
        g2d.setColor(Color.darkGray);
        g2d.setFont(font);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawString(text, -150, bi.getWidth() / 2 + 5);
 
        return image;
    }
 
    @Override
    public Insets getInsets() {
        Insets insets = (Insets) super.getInsets().clone();
        insets.left += imageIcon.getIconWidth();
        return insets;
    }
 
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (imageIcon != null) {
            Insets insets = getInsets();
            g.drawImage(imageIcon.getImage(),
                    insets.left - imageIcon.getIconWidth(),
                    insets.top,
                    null);
        }
    }
 
    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setTitle("swing");
        final JImagedPopupMenu menu = new JImagedPopupMenu("swing");
        menu.add(new JMenuItem("Winzip 8.0"));
        menu.addSeparator();
        menu.add(new JMenuItem("Programs"));
        menu.addSeparator();
        menu.add(new JMenuItem("Document"));
        menu.addSeparator();
        menu.add(new JMenuItem("Run"));
        menu.addSeparator();
        menu.add(new JMenuItem("Shut Down"));
        JLabel label = new JLabel(" click ");
        label.addMouseListener(new java.awt.event.MouseAdapter() {
 
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    menu.show(frame, e.getPoint().x, e.getPoint().y);
                }
            }
        });
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.show();
    }
}