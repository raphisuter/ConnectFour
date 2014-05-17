package connectfour.ui.util;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author Alex
 */
public class JLableCircle extends JLabel {

    @Override
    public void paintComponent(Graphics g) {
        
       // g.setColor(getBackground());
       // g.fillOval(0, 0, 40, 40);
        //g.setColor(Color.blue);
        //g.drawOval(0, 0, 70, 70);
        super.paintComponent(g);
    }
    
}
