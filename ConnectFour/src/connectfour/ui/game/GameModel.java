package connectfour.ui.game;

import connectfour.logic.ConnectFourLogic;
import connectfour.logic.DefaultConnectFourLogic;
import connectfour.model.Player;

/**
 * Diese Klasse repräsentiert das Model.
 *
 * @author Alex
 */
public class GameModel {

    private final ConnectFourLogic logic;

    public GameModel(Player player1, Player player2) {
        this.logic = new DefaultConnectFourLogic(player1, player2);
    }

    /**
     * Wirft einen Stein des Spielers in die entsprechende Kolone. Und wechselt
     * anschliessen den Spieler.
     *
     * @param column Kolone in welche der Stein geworfen wird.
     */
    public void throwStone(int column) {
        logic.throwStone(column);
    }

    /**
     * Gibt den aktuellen Spieler zurück.
     *
     * @return Player Aktueller Spieler.
     */
    public Player getCurrentPlayer() {
        return logic.getCurrentPlayer();
    }

    /**
     * Gibt den Index der Reihe zurück, in welcher der letzte Stein geworfen
     * wurde.
     *
     * @return int Index der Reihe des letzten Steines.
     */
    public int getLastStoneRow() {
        return logic.getLastRow();
    }

    /**
     * Gibt den Index der Kolone zurück, in welcher der letzte Stein geworfen
     * wurde.
     *
     * @return int Index der Kolone des letzten Steines.
     */
    public int getLastStoneColumn() {
        return logic.getLastColumn();
    }
    
    /**
     * Prüft ob die Kolone voll ist.
     * @param column Index der Kolone
     * @return True, falls die Kolone voll ist sonst false.
     */
    public boolean isColumnFull(int column) {
        return logic.isColumnFull(column);
    }
    
}
