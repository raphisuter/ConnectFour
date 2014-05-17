package connectfour.ui.game;

import connectfour.logic.ConnectFourLogic;
import connectfour.logic.ConnectFourLogicChangeListener;
import connectfour.logic.DefaultConnectFourLogic;
import connectfour.model.Player;

/**
 * Diese Klasse repräsentiert das Model. Diese Klasse delegiert alle Aufrufe an
 * die Logik-Komponente.
 *
 * @author Alex
 */
public class GameModel {

    private final ConnectFourLogic logic;

    public GameModel(Player player1, Player player2, int columns, int rows) {
        this.logic = new DefaultConnectFourLogic(player1, player2, columns, rows);
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
     * Fügt einen Modell-Listener hinzu.
     *
     * @param listener ConnectFourLogicChangeListener
     */
    public void addConnectFourLogicChangeListener(ConnectFourLogicChangeListener listener) {
        logic.addConnectFourChangeListener(listener);
    }

}
