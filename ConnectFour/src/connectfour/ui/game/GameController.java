package connectfour.ui.game;

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

    public GameController() {
        // Modell und View erzeugen
        this.model = new GameModel(Player.createPlayer1(), Player.createPlayer2());
        this.view = new GameView(model.getCurrentPlayer());

        // Agieren auf Kolonen Klicks
        this.view.addActionListenerToAllButtons(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO Implementierung basiert auf dem Text des Buttons. Sollte geàndert werden.
                int column = Integer.valueOf(e.getActionCommand());

                // Aktueller Spieler laden
                Player currentPlayer = model.getCurrentPlayer();

                // Stein werfen
                model.throwStone(column);

                // Laden der Position des geworfenen Steines
                column = model.getLastStoneColumn();
                int row = model.getLastStoneRow();

                // View aktualisieren
                view.drawStone(column, row, currentPlayer.getColor());
                view.updateCurrentPlayer(model.getCurrentPlayer());
                
                // Prüfen ob die Kolone noch Platz hat
                if (model.isColumnFull(column)) {
                    view.deactivateColumn(column);
                }
            }
        });
    }

    /**
     * Startet das UI.
     */
    public void showView() {
        this.view.show();
    }

}
