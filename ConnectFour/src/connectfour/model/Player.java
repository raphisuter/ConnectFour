package connectfour.model;

import connectfour.ki.KIMedium;
import java.awt.Color;

/**
 *
 * @author Alex
 */
public abstract class Player {

    private int id;

    private String name;

    private Color color;

    Player(int id, String name, Color color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public static Player createLocalPlayer() {
        return new LocalPlayer(1, System.getProperty("user.name"), Color.red);
    }

    public static Player createComputerPlayer(int cols, int rows) {
        return new ComputerPlayer(2, "Computer", Color.yellow, cols, rows, new KIMedium());
    }
    
    public static Player createNetworkPlayer(String ip) {
        return new NetworkPlayer(2, "Netzwerkspieler " + ip, Color.yellow, ip);
    }

    public abstract void sendThrow(int column);

    public abstract int getNextThrow();

}
