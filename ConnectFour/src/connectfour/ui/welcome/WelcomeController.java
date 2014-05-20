package connectfour.ui.welcome;

import connectfour.model.Player;
import connectfour.networking.UDPServer;
import connectfour.networking.UDPClient;
import connectfour.ui.game.GameController;
import connectfour.ui.searchServer.SearchServerController;
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
                    
                    // Daten setzen
                    model.setNumberOfColumns(view.getColumns());
                    model.setNumberOfRows(view.getRows());
                    model.setPlayComputer(true);
                    model.setPlayHuman(false);
                    
                    // View schliessen
                    view.close();
                    
                    // Spieler erzeugen
                    Player startPlayer = Player.createLocalPlayer();
                    Player otherPlayer = Player.createComputerPlayer(model.getNumberOfColumns(), model.getNumberOfRows());

                    // Game starten
                    GameController controller = new GameController(startPlayer, otherPlayer, model.getNumberOfColumns(), model.getNumberOfRows());
                    controller.showView();
            }
        });

        this.view.addActionListenerMultiPlayerOpen(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // UDPServer Thread mit maxAnzahl versuchen erzeugen und starten
                // TODO Ist diese Anzahl ok?
                UDPServer uServer = new UDPServer(20);
                uServer.start();
            }
        });

        this.view.addActionListenerMultiPlayerJoin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // UDPClient starten
                UDPClient uClient = new UDPClient();
                uClient.start();
                
                // View schliessen
                view.close();
                
                // Controller starten
                SearchServerController controller = new SearchServerController(uClient);
                controller.showView();
            }
        });

    }

    public void showView() {
        this.view.show();
    }
}