package connectfour.model;

import java.awt.Color;

/**
 *
 * @author Alex
 */
public abstract class Player {
    
    private int id;
    
    private String name;
    
    private Color color;
    
    private boolean firstMove;

    public Player(int id, String name, Color color) {
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
        return new LocalPlayer(1, "Lokaler Spieler", Color.red);
    }
    
    public static Player createComputerPlayer() {
        return new ComputerPlayer(2, "Computer", Color.yellow);
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
    
    public abstract void sendThrow(int column);
    
    public abstract int getNextThrow();
    
}
