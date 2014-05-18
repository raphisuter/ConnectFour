package connectfour.logic;

import connectfour.model.Player;

import java.util.Random;

public class DefaultConnectFourLogic implements ConnectFourLogic {

    private Player player1;
    
    private Player player2;
    
    private int maxCol;
    
    private int maxRow;
    
    private int[][] theArray;

    private int lastRow = 0;

    private int lastCol = 0;

    private Player winner = null;

    private int[] notFullCols;

    /**
     * Diese Konstruktor bekommt die beiden teilnehemenden Spieler und die Grösse des Spielfeldes.
     * 
     * Zusätzlich muss gleich ein Aktueller Spieler gesetzt werden. Also entweder fängt Spieler 1 oder
     * Spieler 2 an. Man kann auch machen dass immer Spieler 1 anfängt.
     * 
     * @param player1 Spieler 1
     * @param player2 Spieler 2
     * @param cols Anzahl Kolonen
     * @param rows Anzahl Reihen
     */
    public DefaultConnectFourLogic(Player player1, Player player2, int cols, int rows) {
        this.player1 = player1;
        this.player2 = player2;

        this.maxCol = cols;
        this.maxRow = rows;
     
        this.theArray = new int[maxCol][maxRow];
        this.notFullCols = new int[maxCol];
    }
    
    /**
     * Diese Methode bekommt als Paramter die Kolone in den der Stein geworfen wird.
     * 
     * In dieser Kolone muss berechnet werden wo der oberste Freie Platz ist. Falls
     * die Kolone voll ist, sollte eine RuntimeExepction geworfen werden.
     * Dort wo der Freie Platz ist, kann die ID des aktuellen Spielers gesetzt werden.
     * 
     * Zudem muss nach dem Zug der aktuelle Spieler gewechselt werden.
     * 
     * @param column Kolone
     */
    @Override
    public void throwStone(int column) {
        lastCol = column;

        theArray[lastCol][lastRow] = 1; // TODO WORKING WITH ID OF PLAYER

        lastRow ++;
    }

    /**
     * Das ist ok. Problematisch nur, dass man hier immer zuerst hasWon() aufrufen muss!
     * Sollte eventuell noch konsistent gemacht werden.
     * @return Player Gewinner
     */
    @Override
    public Player getWinner() {
        return this.winner;
    }

    /**
     * Müsste nicht public sein.
     * @param winner 
     */
    public void setWinner(Player winner) {
        this.winner = winner;
    }

    /**
     * Tip Top.
     * @return 
     */
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

    /**
     * Diese Methode muss immer die Kolone zurückgegeben, des zuletzt geworfenen
     * Steines!
     * Das heisst, dass man lastCol in throwStone() setzen muss.
     * 
     * @return 
     */
    @Override
    public int getLastColumn() {
        return lastCol;
    }

    /**
     * Diese Methode muss immer die Reihe zurückgegeben, des zuletzt geworfenen
     * Steines!
     * Das heisst, dass man lastRow in throwStone() setzen muss.
     * 
     * @return 
     */
    @Override
    public int getLastRow() {
        return lastRow;
    }

    /**
     * Sollte natürlich nicht auf Basis eines Zufallwertes den CurrentPlayer
     * zurückgeben. Nach jedem Zug in throwStone() muss der currentPlayer gewechselt werden.
     * @return Player aktueller Spieler
     */
    @Override
    public Player getCurrentPlayer() {
        int zahl = (new Random()).nextInt(2);
        return zahl == 1 ? player1 : player2;
    }

    /**
     * Ich übergebe die Kolone und möchte wissen ob diese Kolone noch Platz hat.
     * Hier müsste ein Loop auf der entsprechende Kolone implementiert werden.
     * @param column
     * @return 
     */
    @Override
    public boolean isColumnFull(int column) {
       if (lastCol == maxCol) {
           return true;
       } else {
           return false;
       }
    }
    
    /**
     * Hier möchte ich alle Kolonen zurück, welche nicht voll sind. notFullColumns
     * ist immer wieder neu und müsste ich nicht als Membervariabel gehalten werden.
     * Das Array darf auch nur so gross sein, wie es Elemente enthalten wird.
     * @return 
     */
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
