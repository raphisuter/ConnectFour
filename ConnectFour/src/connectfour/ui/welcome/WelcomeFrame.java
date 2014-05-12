package connectfour.ui.welcome;

import connectfour.ui.game.GameController;
import connectfour.ui.util.CenterWindowUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Welcome Frame stellt das erste Frame in der Applikation dar. In diesem GUI
 * hat der User die Auswahl ob er gegen den Computer oder gegen einen Mensch
 * spielen will.
 *
 * @author Alex
 */

// TODO Implementierung von MVC durch Java Beginners :)
public class WelcomeFrame {

    private static final String FRAME_TITLE = "Connect 4 - Welcome";

    private static final String BUTTON_SINGLE_PLAYER = "Computer";

    private static final String BUTTON_MULTI_PLAYER = "Mensch";

    private JFrame frame;

    private JButton singlePlayerButton;

    private JButton multiPlayerButton;

    public WelcomeFrame() {
        createFrame();

        createSinglePlayerButton();
        createMultiPlayerButton();

        createLayout();
        setupLayout();
    }

    public void show() {
        frame.setVisible(true);
    }

    private void createFrame() {
        frame = new JFrame(FRAME_TITLE);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterWindowUtil.center(frame);
        frame.setResizable(false);
    }

    private void createLayout() {
        frame.setLayout(null);
    }

    private void setupLayout() {
        singlePlayerButton.setBounds(75, 50, 150, 30);
        multiPlayerButton.setBounds(75, 100, 150, 30);
        frame.getContentPane().add(singlePlayerButton);
        frame.getContentPane().add(multiPlayerButton);
    }

    private void createSinglePlayerButton() {
        singlePlayerButton = new JButton(BUTTON_SINGLE_PLAYER);
        singlePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();

                GameController controller = new GameController();
                controller.showView();
            }
        });
    }

    private void createMultiPlayerButton() {
        multiPlayerButton = new JButton(BUTTON_MULTI_PLAYER);
        multiPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked on multi player");
            }
        });
    }

}
