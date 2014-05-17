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

    public GameController(Player player1, Player player2) {

        // Modell und View erzeugen
        view = new GameView(player1, player2, 7, 6);
        model = new GameModel(player1, player2, 7, 6);
        model.addConnectFourLogicChangeListener(view.getConnectFourLogicChangeListener());

        // Agieren auf Kolonen Klicks
        this.view.addActionListenerToAllButtons(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kolone lesen
                int column = Integer.valueOf(e.getActionCommand());

                // Stein werfen
                model.throwStone(column);
            }
        });

        this.view.addActionListenerClose(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.close();
            }
        });

        this.view.addActionListenerRestart(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("restart");
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
