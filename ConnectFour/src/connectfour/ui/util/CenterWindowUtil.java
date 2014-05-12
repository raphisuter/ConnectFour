package connectfour.ui.util;

import java.awt.Dimension;
import java.awt.Window;

/**
 * Hilfs-Klasse um Windows zu zentrieren.
 */
public class CenterWindowUtil {

    /**
     * Diese Methode mittet ein Window ein.
     * @param window Window, welches eingemittet werden soll.
     */
    public static void center(Window window) {
        Dimension dimension = window.getToolkit().getScreenSize();
        int screenWidth = dimension.width;
        int screenHeight = dimension.height;
        int windowWidth = window.getWidth();
        int windowHeight = window.getHeight();
        window.setLocation((screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2);
    }

}
