package connectfour.ui.welcome;

import connectfour.model.Player;
import connectfour.ui.game.GameController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

                Player player1 = Player.createLocalPlayer();
                Player player2 = Player.createComputerPlayer();
                
                GameController controller = new GameController(player1, player2, 7, 6);
                controller.showView();
            }

        });

        this.view.addActionListenerMultiPlayerOpen(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String player = "Testperson";
                if (player != null) {
                    System.out.println(player);
                    model.setPlayComputer(false);
                    model.setPlayHuman(true);

                    view.close();

                    Player player1 = Player.createLocalPlayer();
                    Player player2 = Player.createComputerPlayer();
                    
                    GameController controller = new GameController(player1, player2, 7, 6);
                    controller.showView();
                } else {
                   // view.showNoChoice();
                }
            }

        });
        
        this.view.addActionListenerMultiPlayerJoin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String player = "Testperson";
                if (player != null) {
                    System.out.println(player);
                    model.setPlayComputer(false);
                    model.setPlayHuman(true);

                    view.close();

                    Player player1 = Player.createLocalPlayer();
                    Player player2 = Player.createComputerPlayer();
                    
                    GameController controller = new GameController(player1, player2, 7, 6);
                    controller.showView();
                } 
            }

        });

       
    }

    public void showView() {
        this.view.show();
    }

}