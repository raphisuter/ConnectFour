package connectfour.ui.game;

import connectfour.model.LocalPlayer;
import connectfour.model.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Arbeitet mit dem Model und der View zusammen. Reagiert auf alle
 * Benutzeraktionen.
 *
 * @author Alex
 */
public class GameController {

    private GameModel model;

    private GameView view;

    private final Player startPlayer;

    private final Player otherPlayer;

    private final Player enemyPlayer;

    private final int columns;

    private final int rows;

    public GameController(Player startPlayer, Player otherPlayer, int columns, int rows) {
        this.columns = columns;
        this.rows = rows;

        this.startPlayer = startPlayer;
        this.otherPlayer = otherPlayer;

        if (startPlayer instanceof LocalPlayer) {
            enemyPlayer = otherPlayer;
        } else {
            enemyPlayer = startPlayer;
        }

        setup();
    }

    /**
     * Startet das UI.
     */
    public void showView() {
        this.view.show();

        this.start();
    }

    private void setup() {
        // Modell und View erzeugen
        view = new GameView(startPlayer, otherPlayer, columns, rows);
        model = new GameModel(startPlayer, otherPlayer, columns, rows);
        model.addConnectFourLogicChangeListener(view.getConnectFourLogicChangeListener());

        // Action Listener registrieren
        view.addActionListenerToAllButtons(createActionListenerColumns());
        view.addActionListenerClose(createActionListenerClose());
        view.addActionListenerRestart(createActionListenerRestart());
    }

    private ActionListener createActionListenerClose() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.close();
            }
        };
    }

    private ActionListener createActionListenerRestart() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.close();
                setup();
                view.show();
            }
        };
    }

    private ActionListener createActionListenerColumns() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Kolone lesen
                int column = Integer.valueOf(e.getActionCommand());

                // Stein werfen
                model.throwStone(column);

                // Nun muss ich dem Gegner den Zug zuschicken
                enemyPlayer.sendThrow(column);

                // Nun die Sache mit dem Enemey
                enemey();

            }
        };
    }

    private void start() {
        if (!(startPlayer instanceof LocalPlayer)) {
            enemey();
        }   
    }

    private void enemey() {
        // UI deaktivieren
        view.deactivateColumns();

        if (!model.hasWon()) {
            // Nun muss ich auf den Zug warten
            int enemyColumn = enemyPlayer.getNextThrow();

            // Auf dem Modell setzen
            model.throwStone(enemyColumn);

            //  UI wieder aktivieren
            view.activateColumns();
        }
    }

}
