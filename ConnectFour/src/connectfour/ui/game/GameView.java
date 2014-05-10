package connectfour.ui.game;

import connectfour.ui.util.CenterWindowUtil;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Präsentiert die Spielansicht.
 *
 * @author Alex
 */
public class GameView {

    private JFrame frame;

    private JButton[] columnButtons;
    
    private JLabel lblTextCurrentPlayer;
    
    private JLabel lblCurrentPlayer;

    public GameView() {

        initComponents();

    }
    
    private void initComponents() {
        createFrame();
        createButtons();
        
        this.lblCurrentPlayer = new JLabel();
        this.lblTextCurrentPlayer = new JLabel("Aktueller Spieler:");
        
        createLayout();
        setupLayout();
    }

    public void show() {
        frame.setVisible(true);
    }

    public void addActionListenerToAllButtons(ActionListener listener) {
        for (JButton button : this.columnButtons) {
            button.addActionListener(listener);
        }
    }
    
    public void updateCurrentPlayer(String player) {
        this.lblCurrentPlayer.setText(player);
    }

    private void createFrame() {
        frame = new JFrame("Connect 4 - Game");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        CenterWindowUtil.center(frame);
    }

    private void createButtons() {
        columnButtons = new JButton[7]; // TODO REFACTOR ANZAHL COLUMNS

        for (int i = 0; i < columnButtons.length; i++) {
            columnButtons[i] = new JButton(String.valueOf(i + 1));
            
        }
        
        
    }

    private void createLayout() {
        frame.setLayout(null);
    }

    private void setupLayout() {
        lblCurrentPlayer.setText("ddd");
        this.lblCurrentPlayer.setBounds(110, 30, 100, 30);
        frame.getContentPane().add(lblCurrentPlayer);
        
        lblTextCurrentPlayer.setBounds(10, 30, 100, 30);
        frame.getContentPane().add(lblTextCurrentPlayer);
        
        int i = 0;
        for (JButton button : this.columnButtons) {
            button.setBounds(10 + i * 70, 70, 45, 30);
            frame.getContentPane().add(button);
            i++;
        }
    }

}
