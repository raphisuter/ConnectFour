package connectfour.ui.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Alex
 */
public class JLabelCircle extends JLabel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, 50, 50);
        g2d.setColor(getBackground());
        g2d.fill(circle);
    }

}
