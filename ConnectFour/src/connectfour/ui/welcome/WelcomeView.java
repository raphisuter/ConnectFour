package connectfour.ui.welcome;

import connectfour.ui.util.CenterWindowUtil;
import connectfour.ui.util.Icon;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Welcome Frame stellt das erste Frame in der Applikation dar. In diesem GUI
 * hat der User die Auswahl ob er gegen den Computer oder gegen einen Mensch
 * spielen will.
 *
 * @author Alex
 */
public class WelcomeView {

    private final String FRAME_TITLE = "Connect 4 - Willkommen";
    private final String BUTTON_SINGLE_PLAYER = "Gegen den Computer";
    private final String BUTTON_MULTI_PLAYERopen = "Spiel eröffnen";
    private final String BUTTON_MULTI_PLAYERjoin = "Spiel beitreten";
    private JLabel textLabel1;
    private JLabel textLabel2;
    private JLabel textLabel3;
    private JLabel textLabel4;
    private JSlider sliderRows;
    private JSlider sliderColumns;
    private final String LABEL_TEXT1 = "Einzelspieler";
    private final String LABEL_TEXT2 = "Mehrspieler";
    private final String LABEL_TEXT3 = "Anzahl Reihen";
    private final String LABEL_TEXT4 = "Anzahl Spalten";
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
        createFieldSizeSliders();

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
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterWindowUtil.center(frame);
        frame.setResizable(false);
        frame.setIconImages(Icon.getIconListGamepad());
    }

    private void createLayout() {
        frame.setLayout(null);
    }

    private void setupLayout() {

        // Einzelspieler
        textLabel1.setBounds(40, 30, 100, 30);
        
        textLabel3.setBounds(40, 70, 100, 30);
        textLabel4.setBounds(40, 120, 100, 30);
        
        sliderColumns.setBounds(150, 75, 400, 50);
        sliderRows.setBounds(150, 125, 400, 50);
        
        singlePlayerButton.setBounds(40, 190, 510, 30);
        
        // Mehrspieler
        textLabel2.setBounds(40, 230, 100, 30);
        
        multiPlayerButtonOpen.setBounds(40, 270, 510, 30);
        multiPlayerButtonJoin.setBounds(40, 310, 510, 30);

        // Komponenten hinzufügen
        frame.getContentPane().add(textLabel1);
        frame.getContentPane().add(textLabel2);
        frame.getContentPane().add(textLabel3);
        frame.getContentPane().add(textLabel4);

        frame.getContentPane().add(singlePlayerButton);
        frame.getContentPane().add(multiPlayerButtonOpen);
        frame.getContentPane().add(multiPlayerButtonJoin);
        frame.getContentPane().add(sliderRows);
        frame.getContentPane().add(sliderColumns);

    }

    private void createLabel() {
        textLabel1 = new JLabel(LABEL_TEXT1);
        textLabel2 = new JLabel(LABEL_TEXT2);
        textLabel3 = new JLabel(LABEL_TEXT3);
        textLabel4 = new JLabel(LABEL_TEXT4);
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

    private void createFieldSizeSliders() {
        sliderRows = new JSlider(JSlider.HORIZONTAL, 4, 20, 6);
        sliderColumns = new JSlider(JSlider.HORIZONTAL, 4, 20, 7);
        
        sliderRows.setMinorTickSpacing(1);
        sliderRows.setMajorTickSpacing(1);
        sliderRows.setPaintTicks(true);
        sliderRows.setPaintLabels(true);
        
        sliderColumns.setMinorTickSpacing(1);
        sliderColumns.setMajorTickSpacing(1);
        sliderColumns.setPaintTicks(true);
        sliderColumns.setPaintLabels(true);
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

    public int getRows() {
        return sliderRows.getValue();
    }

    public int getColumns() {
        return sliderColumns.getValue();
    }
}
