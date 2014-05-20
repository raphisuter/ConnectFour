package connectfour.ui.welcome;

import connectfour.model.Player;
import connectfour.networking.UDPServer;
import connectfour.networking.UDPClient;
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
                    int rows = (view.getRows());
                    int columns = (view.getColumns());
                    model.setPlayComputer(true);
                    model.setPlayHuman(false);
                    view.close();
                    Player player1 = Player.createLocalPlayer();
                    Player player2 = Player.createComputerPlayer(view);

                    GameController controller = new GameController(player1, player2, columns, rows);
                    controller.showView();


            }
        });

        this.view.addActionListenerMultiPlayerOpen(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //UDPServer Thread mit maxAnzahl versuchen erzeugen und starten
                UDPServer uServer = new UDPServer(20);
                uServer.start();
            }
        });

        this.view.addActionListenerMultiPlayerJoin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Test Raphael - nicht löschen
                UDPClient uClient = new UDPClient();
                uClient.start();
            }
        });

    }

    public void showView() {
        this.view.show();
    }
}