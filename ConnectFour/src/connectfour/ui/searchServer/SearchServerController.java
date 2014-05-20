/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour.ui.searchServer;

import connectfour.model.NetworkPlayer;
import connectfour.model.Player;
import connectfour.networking.UDPClient;
import connectfour.ui.game.GameController;
import connectfour.ui.welcome.WelcomeController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
        try {
        Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        this.view = new SearchServerView(setClient.getClientAddressList().toArray());
        this.client = setClient;

        this.view.addActionListenerActualButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Aktualisieren wurde gedrückt"); //Test-Statement
                
                view.setIPadresses(client.getClientAddressList().toArray());
            }

        });
        
        this.view.addActionConnectButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Verbinden wurde gedrückt"); //Test-Statement
                
                String ip = view.getSelectedIPaddress();
                
                NetworkPlayer networkPlayer = new NetworkPlayer(2, "Netzwerkspieler " + ip , Color.GREEN, ip);
                
                GameController controller = new GameController(networkPlayer, Player.createLocalPlayer(), 7, 6);
                
            }

        });

        this.view.addActionListenerBackButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Zurück wurde gedrückt"); //Test-Statement
                
                view.close();
                
                //UDPClient stoppen
                client.setStopThread(true);
                
                WelcomeController controller = new WelcomeController();
                controller.showView();
                
            }

        });

        this.view.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Auswahl in Liste wurde angewählt" + e.toString()); //Test-Statement
                //selectedIPAdress = e.
            }

        });

    }

    public void showView() {
        this.view.show();

    }

}
