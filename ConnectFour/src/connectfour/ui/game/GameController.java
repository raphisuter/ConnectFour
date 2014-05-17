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
    
    private final Player player1;
    
    private final Player player2;

    private final int columns;
            
    private final int rows;
    
    public GameController(Player startPlayer, Player otherPlayer, int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        
        this.player1 = startPlayer;
        this.player2 = otherPlayer;
        
        setup();
    }

    /**
     * Startet das UI.
     */
    public void showView() {
        this.view.show();
    }
    
    private void setup() {
        // Modell und View erzeugen
        view = new GameView(player1, player2, columns, rows);
        model = new GameModel(player1, player2, columns, rows);
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
            }
        };
    }

}
