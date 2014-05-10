package connectfour.ui.game;

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
        this.model = new GameModel();
        this.view = new GameView();
        
        // View intialisieren
        view.updateCurrentPlayer(model.getCurrentPlayer());
        
        // Agieren auf Kolonen Klicks
        this.view.addActionListenerToAllButtons(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // TODO Nicht schön, dass es im e.getActionCommand ist.
                int column = Integer.valueOf(e.getActionCommand());
                model.throwStone(column);
                
                // View aktualisieren
                view.updateCurrentPlayer(model.getCurrentPlayer());
            }
        });
    }
    
    public void showView() {
        this.view.show();
    }

}
