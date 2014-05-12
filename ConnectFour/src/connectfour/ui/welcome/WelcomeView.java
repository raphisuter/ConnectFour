package connectfour.ui.welcome;

import connectfour.ui.game.GameController;
import connectfour.ui.util.CenterWindowUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionListener;

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

    private final String BUTTON_MULTI_PLAYER = "Gegen anderen Spieler";

    private JLabel textLabel1;
    private JLabel textLabel2;
    private JLabel textLabel3;
    private final String LABEL_TEXT1 = "Wähle die Spielart: ";
    private final String LABEL_TEXT2 = "Wähle den Gegner: ";
    private final String LABEL_TEXT3 = "Gegner nicht ausgewählt!";
    
    private JButton singlePlayerButton;

    private JButton multiPlayerButton;

    private JFrame frame;

    private JList<String> playerlist;

    public WelcomeView() {
        createFrame();

        createLabel();
            
        createSinglePlayerButton();
        createMultiPlayerButton();

        createPlayerList();

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
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterWindowUtil.center(frame);
        frame.setResizable(false);
    }

    private void createLayout() {
        frame.setLayout(null);
    }

    private void setupLayout() {
        textLabel3 = new JLabel(LABEL_TEXT3);
        
        textLabel1.setBounds(200, 50, 200, 30);
        textLabel2.setBounds(300, 130, 200, 30);
        textLabel3.setBounds(250, 270, 200, 30);
        singlePlayerButton.setBounds(40, 100, 180, 30);
        
        multiPlayerButton.setBounds(280, 100, 180, 30);
        playerlist.setBounds(300, 160, 150, 100);

        frame.getContentPane().add(textLabel1);
        frame.getContentPane().add(textLabel2);
        frame.getContentPane().add(textLabel3);
        frame.getContentPane().add(singlePlayerButton);
        frame.getContentPane().add(multiPlayerButton);
        frame.getContentPane().add(playerlist);
        
        
        
        
        textLabel3.setVisible(false);

    }

    
    
    private void createLabel(){
        textLabel1 = new JLabel(LABEL_TEXT1);
        textLabel2 = new JLabel(LABEL_TEXT2);
    }
    
    private void createSinglePlayerButton() {
        singlePlayerButton = new JButton(BUTTON_SINGLE_PLAYER);

    }

    private void createMultiPlayerButton() {
        multiPlayerButton = new JButton(BUTTON_MULTI_PLAYER);
    }

    
    
    private void createPlayerList() {
        String[] al1 = {"Kusi", "Raphi", "Alex"};
        this.playerlist = new JList(al1);
        this.playerlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void addActionListenerSinglePlayer(ActionListener Listener) {
        singlePlayerButton.addActionListener(Listener);
    }

    public void addActionListenerMultiPlayer(ActionListener Listener) {
        multiPlayerButton.addActionListener(Listener);
    }

    public String getChoice() {
        return this.playerlist.getSelectedValue();
    }

    public void showNoChoice(){
        
        textLabel3.setVisible(true);
        
       // frame.repaint();
    }
    
    public void hideNoChoice(){
        textLabel3.setVisible(false);
    }
    
    public void addActionListenerMultiPlayerSelection(ListSelectionListener Listener) {
        playerlist.addListSelectionListener(Listener);
    }
}
