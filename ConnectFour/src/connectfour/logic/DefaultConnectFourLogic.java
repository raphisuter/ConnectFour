package connectfour.logic;

import connectfour.model.Player;
import java.util.Random;

// TODO Diese Klasse muss korrekt implementiert werden!
public class DefaultConnectFourLogic implements ConnectFourLogic {

    private Player player1;
    
    private Player player2;
    
    public DefaultConnectFourLogic(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    @Override
    public void throwStone(int column) {
        //?
    }

    @Override
    public Player getWinner() {
        return null;
    }

    @Override
    public boolean hasWon() {
        return false;
    }

    @Override
    public int getLastColumn() {
        return 1;
    }

    @Override
    public int getLastRow() {
        return 1;
    }

    @Override
    public Player getCurrentPlayer() {
        int zahl = (new Random()).nextInt(2);
        return zahl == 1 ? player1 : player2;
    }

    @Override
    public boolean isColumnFull(int column) {
       return false;
    }
    
}
