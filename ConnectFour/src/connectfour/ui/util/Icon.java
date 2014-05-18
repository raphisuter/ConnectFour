
package connectfour.ui.util;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Alex
 */
public class Icon {
    
    public static List<Image> getIconListGamepad() {
        List<Image> icons = new ArrayList<>();
        icons.add(createImage("/connectfour/images/gamepad_128x128.png"));
        icons.add(createImage("/connectfour/images/gamepad_64x64.png"));
        icons.add(createImage("/connectfour/images/gamepad_48x48.png"));
        return icons;
    }
    
    private static Image createImage(String url) {
        URL iconURL = Icon.class.getResource(url);
        ImageIcon icon = new ImageIcon(iconURL);
        return icon.getImage();
    } 
    
}
