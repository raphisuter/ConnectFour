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
        Player player1 = Player.createPlayer1(); // TODO müssen von aussen gesetzt werden
        Player player2 = Player.createPlayer2(); // TODO müssen von aussen gesetzt werden

        // Modell und View erzeugen
        this.model = new GameModel(player1, player2, 7, 6); // TODO Duplicated Code
        this.view = new GameView(player1, player2, 7, 6); //  TODO Duplicated Code!
        this.view.updateCurrentPlayer(this.model.getCurrentPlayer());

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
                int lastColumn = model.getLastStoneColumn();
                int lastRow = model.getLastStoneRow();

                // View aktualisieren
                view.drawStone(lastColumn, lastRow, currentPlayer.getColor());

                // Prüfen ob jemand gewonnen hat.
                if (model.hasWon()) {
                    view.showWinner(model.getWinner());
                    view.close();
                }

                // Nach dem Zug, wechselt der aktuelle Spieler
                view.updateCurrentPlayer(model.getCurrentPlayer());
                
                // Warten auf Zug des anderen Spielers
                view.deactivateAllColumns();
                
                // TODO Zug an Gegner senden
                
                // TODO Zug von Gegner erhalten

                boolean enemyHasMakeAThrow = false;
                while (!enemyHasMakeAThrow) {
                    enemyHasMakeAThrow = true;
                }

                // Prüfen ob die Kolone noch Platz hat
                for (int notFullColumn : model.getAllNotFullColumns()) {
                    view.activateColumn(notFullColumn);
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
