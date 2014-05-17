package connectfour.logic;

import connectfour.model.Player;

/**
 *
 * @author Alex
 */
public interface ConnectFourLogic {

    /**
     * Wirft einen Stein vom Spieler in die entsprechende Kolone.
     *
     * @param column Kolone in welcher der Stein geworfen wird.
     */
    void throwStone(int column);

    /**
     * Gibt den Gewinner zurück.
     *
     * @return Player Gewinner.
     */
    Player getWinner();

    /**
     * Prüft ob ein Spieler gewonnen hat.
     *
     * @return boolean True, falls jemand gewonnen hat sonst false.
     */
    boolean hasWon();

    /**
     * Gibt den Index der Kolone zurück, in welcher der letzte Stein geworfen
     * wurde.
     *
     * @return int Index der Kolone des letzten Steines.
     */
    int getLastColumn();

    /**
     * Gibt den Index der Reihe zurück, in welcher der letzte Stein geworfen
     * wurde.
     *
     * @return int Index der Reihe des letzten Steines.
     */
    int getLastRow();
    
    /**
     * Gibt den aktuellen Spieler zurück.
     * @return Player Aktueller Spieler.
     */
    Player getCurrentPlayer();
    
    /**
     * Prüft ob die Kolone noch Platz für weitere Steine hat.
     * @param column Index der Kolone.
     * @return True, falls die Kolone voll ist, anderenfalls false.
     */
    boolean isColumnFull(int column);
    
    /**
     * Gibt alle Index der Kolonen zurück, welche nicht voll sind.
     * @return int[] Index aller nicht vollen Kolonen.
     */
    int[] getAllNotFullColumns();

    void addConnectFourChangeListener(ConnectFourLogicChangeListener listener);
    
}
