package connectfour.ui.game;

import connectfour.model.Player;
import connectfour.ui.util.CenterWindowUtil;
import java.awt.Color;
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
    
    private JLabel[][] stoneLabels;
    
    private JLabel lblTextCurrentPlayer;
    
    private JLabel lblCurrentPlayer;

    public GameView(Player currentPlayer) {
        createFrame();
        createButtons();
        createLabels(currentPlayer);
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
    
    public void updateCurrentPlayer(Player player) {
        this.lblCurrentPlayer.setText(player.getName());
    }

    private void createLabels(Player player) {
        this.lblCurrentPlayer = new JLabel();
        this.lblTextCurrentPlayer = new JLabel("Aktueller Spieler:");
        
        stoneLabels = new JLabel[7][6]; // TODO REFACTOR ANZAHL COLUMNS

        for (int c = 0; c < stoneLabels.length; c++) {
            for (int r = 0; r < stoneLabels[c].length; r++) {
                stoneLabels[c][r] = new JLabel();
                stoneLabels[c][r].setBackground(Color.white);
                stoneLabels[c][r].setOpaque(true);
                stoneLabels[c][r].setText(String.valueOf(c) + " " + String.valueOf(r));
            }
        }
       
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
    
    public void drawStone(int x, int y, Color color) {
        stoneLabels[x-1][y-1].setBackground(color);
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
        
        for (int c = 0; c < stoneLabels.length; c++) {
            for (int r = 0; r < stoneLabels[c].length; r++) {
                JLabel lbl = stoneLabels[c][r];
                System.out.println("hey");
                lbl.setBounds(10 + c * 70, 400 - r * 55, 45, 45);
                
                //lbl.setBounds(10, 120, 45, 45);
                frame.getContentPane().add(lbl);
            }
        }
        
    }
    
    public void deactivateColumn(int column) {
        columnButtons[column].setEnabled(false);
    }

}
