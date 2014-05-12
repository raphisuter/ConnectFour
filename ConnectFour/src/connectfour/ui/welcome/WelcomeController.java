/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour.ui.welcome;

import connectfour.ui.game.GameController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI;

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

                GameController controller = new GameController();
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

                    GameController controller = new GameController();
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
