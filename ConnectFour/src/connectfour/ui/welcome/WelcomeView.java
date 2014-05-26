package connectfour.ui.welcome;

import connectfour.ki.KI;
import connectfour.ki.KIMedium;
import connectfour.ki.KISimple;
import connectfour.model.DefaultConfiguration;
import connectfour.ui.util.CenterWindowUtil;
import connectfour.ui.util.Icon;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    private JComboBox<String> strength;

    /**
     * Konstruktor, erzeugt das Welcome-GUI
     */
    public WelcomeView() {
        createFrame();

        createLabel();

        createSinglePlayerButton();
        createMultiPlayerButtonOpen();
        createMultiPlayerButtonJoin();
        createFieldSizeSliders();
        createStrength();

        createLayout();
        setupLayout();
    }

    /**
     * Methode um das Frame anzuzeigen
     */
    public void show() {
        frame.setVisible(true);
    }

    /**
     * Methode um das Frame zu verbergen
     */
    public void close() {
        frame.setVisible(false);
        frame.dispose();
    }

    /**
     * Methode um das Frame zu erzeugen
     */
    private void createFrame() {
        frame = new JFrame(FRAME_TITLE);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImages(Icon.getIconListGamepad());
        CenterWindowUtil.center(frame);
    }

    /**
     * Methode um das Layout zu erzeugen
     */
    private void createLayout() {
        frame.setLayout(null);
    }

    /**
     * Methode um die Elemente dem Layout hinzuzufügen und korrekt zu skalieren
     */
    private void setupLayout() {

        // Einzelspieler
        textLabel1.setBounds(40, 30, 100, 30);
        
        textLabel4.setBounds(40, 70, 100, 30);
        textLabel3.setBounds(40, 120, 100, 30);
        
        sliderColumns.setBounds(150, 75, 400, 50);
        sliderRows.setBounds(150, 125, 400, 50);
        
        strength.setBounds(40, 190, 80, 30);
        singlePlayerButton.setBounds(130, 190, 420, 30);
        
        // Mehrspieler
        textLabel2.setBounds(40, 230, 100, 30);
        
        multiPlayerButtonOpen.setBounds(40, 270, 510, 30);
        multiPlayerButtonJoin.setBounds(40, 310, 510, 30);

        // Komponenten hinzufügen
        frame.getContentPane().add(textLabel1);
        frame.getContentPane().add(textLabel2);
        frame.getContentPane().add(textLabel3);
        frame.getContentPane().add(textLabel4);
        frame.getContentPane().add(strength);
        frame.getContentPane().add(singlePlayerButton);
        frame.getContentPane().add(multiPlayerButtonOpen);
        frame.getContentPane().add(multiPlayerButtonJoin);
        frame.getContentPane().add(sliderRows);
        frame.getContentPane().add(sliderColumns);

    }

    /**
     * Methode um die Textlabels zu erzeugen
     */
    private void createLabel() {
        textLabel1 = new JLabel(LABEL_TEXT1);
        textLabel2 = new JLabel(LABEL_TEXT2);
        textLabel3 = new JLabel(LABEL_TEXT3);
        textLabel4 = new JLabel(LABEL_TEXT4);
    }

    /**
     * Methode um den Knopf "Gegen den Computer" zu erzeugen
     */
    private void createSinglePlayerButton() {
        singlePlayerButton = new JButton(BUTTON_SINGLE_PLAYER);

    }

    /**
     * Methode um den Knopf "Spiel eröffnen" zu erzeugen
     */
    private void createMultiPlayerButtonOpen() {
        multiPlayerButtonOpen = new JButton(BUTTON_MULTI_PLAYERopen);
    }

    /**
     * Methode um den Knopf "Spiel beitreten" zu erzeugen
     */
    private void createMultiPlayerButtonJoin() {
        multiPlayerButtonJoin = new JButton(BUTTON_MULTI_PLAYERjoin);
    }

    /**
     * Methode um die Schieber für die Anzahl Spalten und Zeilen des Spiels zu erzeugen
     */
    private void createFieldSizeSliders() {
        sliderRows = createSlider(DefaultConfiguration.ROWS);
        sliderColumns = createSlider(DefaultConfiguration.COLUMNS);
    }
    
    /**
     * Methode um die Schwierigkeitslevels der Auswahlliste hinzuzufügen
     */
    private void createStrength() {
        List<Object> str = new ArrayList<>();
        str.add(new KISimple());
        str.add(new KIMedium());
        
        strength = new JComboBox(str.toArray());
    }

    /**
     * Methode um die Schieber zu definieren
     * @param defaultValue
     * @return slider
     */
    private JSlider createSlider(int defaultValue) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 4, 20, defaultValue);
        
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        return slider;
    }
    
    /**
     * Methode um dem Knopf "Gegen den Computer" den ActionListner hinzuzufügen
     * @param Listener 
     */
    public void addActionListenerSinglePlayer(ActionListener Listener) {
        singlePlayerButton.addActionListener(Listener);
    }

    /**
     * Methode um dem Knopf "Spiel eröffnen" den ActionListener hinzuzufügen
     * @param Listener 
     */
    public void addActionListenerMultiPlayerOpen(ActionListener Listener) {
        multiPlayerButtonOpen.addActionListener(Listener);
    }

    /**
     * Methode um dem Knopf "Spiel beitreten" den ActionListener hinzuzufügen
     * @param Listener 
     */
    public void addActionListenerMultiPlayerJoin(ActionListener Listener) {
        multiPlayerButtonJoin.addActionListener(Listener);
    }

    /**
     * Methode um die Anzahl Zeilen zu bekommen, anhand der Stellung des Schiebers
     * @return 
     */
    public int getRows() {
        return sliderRows.getValue();
    }

    /**
     * Methode um die Anzahl Spalten zu bekommen, anhand der Stellung des Schiebers
     * @return 
     */
    public int getColumns() {
        return sliderColumns.getValue();
    }
    
    /**
     * Methode um die Auswahl des Schwierigkeitslevel zu erhalten
     * @return 
     */
    public KI getStrength() {
        return (KI) strength.getSelectedItem();
    }
}
