package connectfour.ui.game;

/**
 * Diese Klasse hält das Spielfeld als 2-dimensionales Array.
 *
 * @author Alex
 */
public class GameModel {

    private final static int player1 = 1;

    private final static int player2 = 2;
    
    private int currentPlayer;

    public GameModel() {
        currentPlayer = player1;
    }
    
    public void throwStone(int column) {
          // entsprechende column füllen
        
          // check ob jemand gewonnen hat und das müsste dem controller gemeldet werden
        
          // view neu zeichnen
  
        
        // change player
        tooglePlayer();
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
