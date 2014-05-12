package connectfour.logic;

import connectfour.model.Player;
import connectfour.ui.game.GameController;
import connectfour.ui.game.GameView;

import java.util.Random;

// TODO Diese Klasse muss korrekt implementiert werden!
public class DefaultConnectFourLogic extends GameController implements ConnectFourLogic {

    private Player player1;
    
    private Player player2;

    private GameView view;

    private int maxRow = view.getMaxRow();

    private int maxCol = view.getMaxCol();

    private int[][] theArray = new int[maxCol][maxRow];

    private int lastRow = 0;

    private int lastCol = 0;

    private Player winner = null;

    private int[] notFullCols = new int[maxCol];

    public DefaultConnectFourLogic(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

    }
    
    @Override
    public void throwStone(int column) {
        lastCol = column;

        theArray[lastCol][lastRow] = 1;

        lastRow ++;
    }

    @Override
    public Player getWinner() {
        return this.winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    @Override
    public boolean hasWon() {
        // Horizontale Prüfung
        for (int row=0; row<maxRow; row++) {
            for (int col=0; col<maxCol-3; col++) {
                int curr = theArray[row][col];
                if (curr>0
                        && curr == theArray[row][col+1]
                        && curr == theArray[row][col+2]
                        && curr == theArray[row][col+3]) {
                    setWinner(getCurrentPlayer());
                    return true;
                }
            }
        }
        // Vertikale Prüfung
        for (int col=0; col<maxCol; col++) {
            for (int row=0; row<maxRow-3; row++) {
                int curr = theArray[row][col];
                if (curr>0
                        && curr == theArray[row+1][col]
                        && curr == theArray[row+2][col]
                        && curr == theArray[row+3][col]) {
                    setWinner(getCurrentPlayer());
                    return true;
                }
            }
        }
        // Diagonale unten links nach oben rechts
        for (int row=0; row<maxRow-3; row++) {
            for (int col=0; col<maxCol-3; col++) {
                int curr = theArray[row][col];
                if (curr>0
                        && curr == theArray[row+1][col+1]
                        && curr == theArray[row+2][col+2]
                        && curr == theArray[row+3][col+3]) {
                    setWinner(getCurrentPlayer());
                    return true;
                }
            }
        }
        // Diagonale oben links nach unten rechts
        for (int row=maxRow-1; row>=3; row--) {
            for (int col=0; col<maxCol-3; col++) {
                int curr = theArray[row][col];
                if (curr>0
                        && curr == theArray[row-1][col+1]
                        && curr == theArray[row-2][col+2]
                        && curr == theArray[row-3][col+3]) {
                    setWinner(getCurrentPlayer());
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int getLastColumn() {
        return lastCol;
    }

    @Override
    public int getLastRow() {
        return lastRow;
    }

    @Override
    public Player getCurrentPlayer() {
        int zahl = (new Random()).nextInt(2);
        return zahl == 1 ? player1 : player2;
    }

    @Override
    public boolean isColumnFull(int column) {

       if (lastCol == maxCol) {
           return true;
       } else {
           return false;
       }
    }
    
    @Override
    public int[] getAllNotFullColumns() {
        int i = 0;

        for (int col=0; col<maxCol; col++) {
            if(!isColumnFull(col)){
                notFullCols[i] = col;
                i++;
            }
        }

        return notFullCols;
    }
    
}
