package connectfour.ui.game;

import java.awt.Color;

/**
 * Diese Klasse hält das Spielfeld als 2-dimensionales Array.
 *
 * @author Alex
 */
public class GameModel {

    private final static int player1 = 1;

    private final static int player2 = 2;
    
    private final static Color player1Color = Color.YELLOW;
    
    private final static Color player2Color = Color.RED;
    
    private int currentPlayer;

    private int lastStoneY = 0;
    
    private int lastStoneX = 0;
    
    public GameModel() {
        currentPlayer = player1;
    }
    
    public void throwStone(int column) {
          // entsprechende column füllen
        
          // check ob jemand gewonnen hat und das müsste dem controller gemeldet werden
        
          // view neu zeichnen
  
        lastStoneX = column;
        lastStoneY++;
        
        // change player
        tooglePlayer();
    }
    
    public Color getCurrentPlayerColor() {
        if (currentPlayer == player1) {
            return player1Color;
        } else {
            return player2Color;
        }
    }
    
    public int getLastStoneX() {
        return lastStoneX;
    }
    
    public int getLastStoneY() {
        return lastStoneY;
    }
    
    private void tooglePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
    
    public String getCurrentPlayer() {
        return String.valueOf(currentPlayer);
    }
    
}
