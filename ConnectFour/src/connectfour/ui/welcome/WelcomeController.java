package connectfour.ui.welcome;

import connectfour.model.Player;
import connectfour.ui.game.GameController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Markus
 */
public class WelcomeController {

    private WelcomeModel model;

    private WelcomeView view;

    public WelcomeController() {
        this.model = new WelcomeModel();
        this.view = new WelcomeView();

        this.view.addActionListenerSinglePlayer(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setPlayComputer(true);
                model.setPlayHuman(false);
                view.close();

                Player player1 = Player.createPlayer1();
                Player player2 = Player.createPlayer2();
                
                GameController controller = new GameController(player1, player2);
                controller.showView();
            }

        });

        this.view.addActionListenerMultiPlayer(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String player = view.getChoice();
                if (player != null) {
                    System.out.println(player);
                    model.setPlayComputer(false);
                    model.setPlayHuman(true);

                    view.close();

                    Player player1 = new Player(10, player, Color.MAGENTA);
                    Player player2 = Player.createPlayer2();
                    
                    GameController controller = new GameController(player1, player2);
                    controller.showView();
                } else {
                    view.showNoChoice();
                }
            }

        });

        this.view.addActionListenerMultiPlayerSelection(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                view.hideNoChoice();
            }

        });
    }

    public void showView() {
        this.view.show();
    }

}
