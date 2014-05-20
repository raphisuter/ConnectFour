package connectfour.ui.searchServer;

import connectfour.model.DefaultConfiguration;
import connectfour.model.Player;
import connectfour.networking.UDPClient;
import connectfour.networking.UDPPlay;
import connectfour.ui.game.GameController;
import connectfour.ui.welcome.WelcomeController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Markus
 */
public class SearchServerController {

    private SearchServerModel model;
    private SearchServerView view;

    private UDPClient client;

    public SearchServerController(UDPClient setClient) {
        this.model = new SearchServerModel();
        
        // Wir warten 1 Sekunde bis auf dem Client die IP Adress Liste gestzt ist.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.view = new SearchServerView(setClient.getClientAddressList().toArray());
        this.client = setClient;

        this.view.addActionListenerActualButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Aktualisieren der IP Adressen");
                view.setIPadresses(client.getClientAddressList().toArray());
            }

        });

        this.view.addActionConnectButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = view.getSelectedIPaddress();
                System.out.println("Verbinden mit " + ip);

                UDPPlay uplay = new UDPPlay(ip);
                uplay.start();
                
                Player startPlayer = Player.createNetworkPlayer(ip);
                Player otherPlayer = Player.createLocalPlayer();

                GameController controller = new GameController(startPlayer, otherPlayer, DefaultConfiguration.COLUMNS, DefaultConfiguration.ROWS);
                controller.showView();
            }

        });

        this.view.addActionListenerBackButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Zurück");

                // Fenster schliessen
                view.close();

                // UDPClient stoppen
                client.setStopThread(true);

                // Welcome zeigen
                WelcomeController controller = new WelcomeController();
                controller.showView();
            }

        });
        
    }

    public void showView() {
        this.view.show();
    }

}
