package connectfour.ui.game;

import java.awt.Color;
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
                
                String currentPlayer = model.getCurrentPlayer();
                Color currentPlayerColor = model.getCurrentPlayerColor();
                
                model.throwStone(column);
                
                int x = model.getLastStoneX();
                int y = model.getLastStoneY();
                
                // View aktualisieren
                view.drawStone(x, y, currentPlayerColor);
                view.updateCurrentPlayer(model.getCurrentPlayer());
               
                
                
            }
        });
    }
    
    public void showView() {
        this.view.show();
    }

}
