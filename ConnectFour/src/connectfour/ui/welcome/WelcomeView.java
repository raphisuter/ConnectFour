package connectfour.ui.welcome;

import connectfour.ui.util.CenterWindowUtil;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Welcome Frame stellt das erste Frame in der Applikation dar. In diesem GUI
 * hat der User die Auswahl ob er gegen den Computer oder gegen einen Mensch
 * spielen will.
 *
 * @author Alex
 */
// TODO Implementierung von MVC durch Java Beginners :)
public class WelcomeView {

    private final String FRAME_TITLE = "Connect 4 - Welcome";

    private final String BUTTON_SINGLE_PLAYER = "Gegen den Computer";

    private final String BUTTON_MULTI_PLAYERopen = "Spiel eröffnen";
    private final String BUTTON_MULTI_PLAYERjoin = "Spiel beitreten";

    private JLabel textLabel1;
    private JLabel textLabel2;
    private JLabel textLabel3;
    private final String LABEL_TEXT1 = "Single-Player";
    private final String LABEL_TEXT2 = "Multi-Player";
   

    private JButton singlePlayerButton;

    private JButton multiPlayerButtonOpen;
    private JButton multiPlayerButtonJoin;
    
    private JFrame frame;

    

    public WelcomeView() {
        createFrame();

        createLabel();

        createSinglePlayerButton();
        createMultiPlayerButtonOpen();
        createMultiPlayerButtonJoin();

        

        createLayout();
        setupLayout();

    }

    public void show() {
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
        frame.dispose();
    }

    private void createFrame() {
        frame = new JFrame(FRAME_TITLE);
        frame.setSize(620, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterWindowUtil.center(frame);
        frame.setResizable(false);
    }

    private void createLayout() {
        frame.setLayout(null);
    }

    private void setupLayout() {
        

        textLabel1.setBounds(85, 30, 200, 30);
        textLabel2.setBounds(390, 30, 200, 30);
        
        singlePlayerButton.setBounds(40, 70, 170, 30);

        multiPlayerButtonOpen.setBounds(270, 70, 150, 30);
        multiPlayerButtonJoin.setBounds(430, 70, 150, 30);

        frame.getContentPane().add(textLabel1);
        frame.getContentPane().add(textLabel2);
        
        frame.getContentPane().add(singlePlayerButton);
        frame.getContentPane().add(multiPlayerButtonOpen);
        frame.getContentPane().add(multiPlayerButtonJoin);

        

    }

    private void createLabel() {
        textLabel1 = new JLabel(LABEL_TEXT1);
        textLabel2 = new JLabel(LABEL_TEXT2);
    }

    private void createSinglePlayerButton() {
        singlePlayerButton = new JButton(BUTTON_SINGLE_PLAYER);

    }

    private void createMultiPlayerButtonOpen() {
        multiPlayerButtonOpen = new JButton(BUTTON_MULTI_PLAYERopen);
    }
    
    private void createMultiPlayerButtonJoin() {
        multiPlayerButtonJoin = new JButton(BUTTON_MULTI_PLAYERjoin);
    }

    public void addActionListenerSinglePlayer(ActionListener Listener) {
        singlePlayerButton.addActionListener(Listener);
    }

    public void addActionListenerMultiPlayerOpen(ActionListener Listener) {
        multiPlayerButtonOpen.addActionListener(Listener);
    }
    
    public void addActionListenerMultiPlayerJoin(ActionListener Listener) {
        multiPlayerButtonJoin.addActionListener(Listener);
    }

    
}