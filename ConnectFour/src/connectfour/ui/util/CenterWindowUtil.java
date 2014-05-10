package connectfour.ui.util;

import java.awt.Dimension;
import java.awt.Window;

/**
 * Class to center a window.
 */
public class CenterWindowUtil {

    public static void center(Window window) {
        Dimension dimension = window.getToolkit().getScreenSize();
        int screenWidth = dimension.width;
        int screenHeight = dimension.height;
        int windowWidth = window.getWidth();
        int windowHeight = window.getHeight();
        window.setLocation((screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2);
    }

}
