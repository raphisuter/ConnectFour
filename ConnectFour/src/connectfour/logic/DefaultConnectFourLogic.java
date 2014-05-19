package connectfour.logic;

import connectfour.model.Player;
import connectfour.model.Stone;
import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;

public class DefaultConnectFourLogic implements ConnectFourLogic {

    private Player player1;
    
    private Player player2;

    private Player currentPlayer;
    
    private int maxCol;
    
    private int maxRow;
    
    private int[][] theArray;

    private int lastRow = 1;

    private int lastCol = 1;

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

        this.currentPlayer = this.player1;

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
        if (!isColumnFull(column)){
            this.lastCol = column;
            setLastRow();
            theArray[lastCol-1][lastRow-1] = this.currentPlayer.getId();


            // Notifizieren, dass es einen neuen Stein gibt
            Stone stone = new Stone(lastCol, lastRow, getCurrentPlayer());
            firePropertyChangeNewStoneAdded(stone);

            // Prüfen ob eine Kolone voll ist, dann melde
            int indexLastRowOfColumn = theArray[lastCol-1].length - 1;
            //System.out.println(theArray[indexColumn][indexLastRowOfColumn]);
            if (theArray[lastCol-1][indexLastRowOfColumn] != 0) {
                firePropertyChangeColumnIsFull(lastCol);
            }

            // Hier prüfen ob jemand gewonnen hat und falls ja Gewinner notifizieren
               if (hasWon()){
                   firePropertyChangeWinner(this.winner);
               }

            // Hier notifizieren, weil der currentPlayer gewechselt hat
                switchPlayer();
                firePropertyChangeCurrentPlayer(this.currentPlayer);

        } else {
            throw new RuntimeException("Diese Kolone ist voll!");
        }
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
     * Tip Top.
     * @return 
     */
    @Override
    public boolean hasWon() {
        // Horizontale Prüfung
        for (int row=0; row<maxRow; row++) {
            for (int col=0; col<maxCol-3; col++) {
                int curr = theArray[col][row];
                if (curr>0
                        && curr == theArray[col+1][row]
                        && curr == theArray[col+2][row]
                        && curr == theArray[col+3][row]) {
                    //switchPlayer();
                    this.winner = getCurrentPlayer();
                    return true;
                }
            }
        }
        // Vertikale Prüfung
        for (int col=0; col<maxCol; col++) {
            for (int row=0; row<maxRow-3; row++) {
                int curr = theArray[col][row];
                if (curr>0
                        && curr == theArray[col][row+1]
                        && curr == theArray[col][row+2]
                        && curr == theArray[col][row+3]) {
                    //switchPlayer();
                    this.winner = getCurrentPlayer();
                    return true;
                }
            }
        }
        // Diagonale unten links nach oben rechts
        for (int row=0; row<maxRow-3; row++) {
            for (int col=0; col<maxCol-3; col++) {
                int curr = theArray[col][row];
                if (curr>0
                        && curr == theArray[col+1][row+1]
                        && curr == theArray[col+2][row+2]
                        && curr == theArray[col+3][row+3]) {
                    //switchPlayer();
                    this.winner = getCurrentPlayer();
                    return true;
                }
            }
        }
        // Diagonale oben links nach unten rechts
        for (int row=maxRow-1; row>=3; row--) {
            for (int col=0; col<maxCol-3; col++) {
                int curr = theArray[col][row];
                if (curr>0
                        && curr == theArray[col+1][row-1]
                        && curr == theArray[col+2][row-2]
                        && curr == theArray[col+3][row-3]) {
                    //switchPlayer();
                    this.winner = getCurrentPlayer();
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
        return this.lastCol;
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
        return this.lastRow;
    }

    private void setLastRow(){
        for (int row=1; row<maxRow+1; row++) {
            if (!(this.theArray[this.lastCol-1][row-1]>0)){
                this.lastRow = row;
                break;
            }
        }
    }

    /**
     * Sollte natürlich nicht auf Basis eines Zufallwertes den CurrentPlayer
     * zurückgeben. Nach jedem Zug in throwStone() muss der currentPlayer gewechselt werden.
     * @return Player aktueller Spieler
     */
    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    private void switchPlayer(){
        if (getCurrentPlayer() == player1){
            this.currentPlayer = player2;
        } else {
            this.currentPlayer = player1;
        }
    }

    /**
     * Ich übergebe die Kolone und möchte wissen ob diese Kolone noch Platz hat.
     * Hier müsste ein Loop auf der entsprechende Kolone implementiert werden.
     * @param column
     * @return 
     */
    @Override
    public boolean isColumnFull(int column) {
        for (int row=0; row<maxRow; row++) {
            if (!(this.theArray[column-1][row]>0)){
                return false;
            }
        }
        return true;
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
        for (int col=1; col<maxCol+1; col++) {
            if(!isColumnFull(col)){
                notFullCols[i] = col-1;
                i++;
            }
        }
        return Arrays.copyOf(notFullCols, i);
    }

    private List<ConnectFourLogicChangeListener> listeners = new ArrayList<>();

    @Override
    public void addConnectFourChangeListener(ConnectFourLogicChangeListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }

    private void firePropertyChangeCurrentPlayer(Player player) {
        for (ConnectFourLogicChangeListener listener : listeners) {
            listener.changedCurrentPlayer(player);
        }
    }

    private void firePropertyChangeWinner(Player player) {
        for (ConnectFourLogicChangeListener listener : listeners) {
            listener.notifyWinner(player);
        }
    }

    private void firePropertyChangeColumnIsFull(int column) {
        for (ConnectFourLogicChangeListener listener : listeners) {
            listener.notifyColumnIsFull(column);
        }
    }

    private void firePropertyChangeNewStoneAdded(Stone stone) {
        for (ConnectFourLogicChangeListener listener : listeners) {
            listener.addedNewStone(stone);
        }
    }
}
