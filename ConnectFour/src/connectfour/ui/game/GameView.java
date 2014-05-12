package connectfour.ui.game;

import connectfour.model.Player;
import connectfour.ui.util.CenterWindowUtil;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 * Präsentiert die Spielansicht.
 *
 * @author Alex
 */
public class GameView {

    private JFrame frame;

    private JButton[] columnButtons;

    private JLabel[][] stoneLabels;

    private JLabel lblPlayer1Color;

    private JLabel lblPlayer2Color;

    private JLabel lblPlayer1Name;

    private JLabel lblPlayer2Name;

    public int getMaxCol() {
        return maxCol;
    }

    public void setMaxCol(int maxCol) {
        this.maxCol = maxCol;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(int maxRow) {
        this.maxRow = maxRow;
    }

    private int maxCol = 7;

    private int maxRow = 6;
    
    public GameView(Player player1, Player player2) {
        createFrame();
        createButtons();
        createLabels(player1, player2);
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
        Border borderCurrentPlayer = BorderFactory.createLineBorder(Color.BLACK, 3);
        Border borderOtherPlayer = null;

        if (this.lblPlayer1Color.getBackground().equals(player.getColor())) {
            this.lblPlayer1Color.setBorder(borderCurrentPlayer);
            this.lblPlayer2Color.setBorder(borderOtherPlayer);
        } else {
            this.lblPlayer2Color.setBorder(borderCurrentPlayer);
            this.lblPlayer1Color.setBorder(borderOtherPlayer);
        }
    }

    private void createLabels(Player player1, Player player2) {
        this.lblPlayer1Name = new JLabel(player1.getName());
        this.lblPlayer2Name = new JLabel(player2.getName());

        this.lblPlayer1Color = new JLabel();
        this.lblPlayer1Color.setBackground(player1.getColor());
        this.lblPlayer1Color.setOpaque(true);

        this.lblPlayer2Color = new JLabel();
        this.lblPlayer2Color.setBackground(player2.getColor());
        this.lblPlayer2Color.setOpaque(true);

        stoneLabels = new JLabel[maxCol][maxRow]; // TODO REFACTOR ANZAHL COLUMNS

        for (int c = 0; c < stoneLabels.length; c++) {
            for (int r = 0; r < stoneLabels[c].length; r++) {
                stoneLabels[c][r] = new JLabel();
                stoneLabels[c][r].setBackground(Color.white);
                stoneLabels[c][r].setOpaque(true);
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
        columnButtons = new JButton[maxCol]; // TODO REFACTOR ANZAHL COLUMNS

        for (int i = 0; i < columnButtons.length; i++) {
            columnButtons[i] = new JButton(String.valueOf(i + 1));
        }

    }

    private void createLayout() {
        frame.setLayout(null);
    }

    public void drawStone(int x, int y, Color color) {
        stoneLabels[x - 1][y - 1].setBackground(color);
    }

    private void setupLayout() {
        this.lblPlayer1Name.setBounds(30, 12, 100, 30);
        frame.getContentPane().add(lblPlayer1Name);

        this.lblPlayer2Name.setBounds(30, 32, 100, 30);
        frame.getContentPane().add(lblPlayer2Name);

        this.lblPlayer1Color.setBounds(10, 20, 15, 15);
        frame.getContentPane().add(lblPlayer1Color);

        this.lblPlayer2Color.setBounds(10, 40, 15, 15);
        frame.getContentPane().add(lblPlayer2Color);

        int i = 0;
        for (JButton button : this.columnButtons) {
            button.setBounds(10 + i * 70, 70, 45, 30);
            frame.getContentPane().add(button);
            i++;
        }

        for (int c = 0; c < stoneLabels.length; c++) {
            for (int r = 0; r < stoneLabels[c].length; r++) {
                JLabel lbl = stoneLabels[c][r];
                lbl.setBounds(10 + c * 70, 400 - r * 55, 45, 45);
                frame.getContentPane().add(lbl);
            }
        }

    }

    public void deactivateAllColumns() {
        for (JButton button : columnButtons) {
            button.setEnabled(false);
        }
    }

    public void deactivateColumn(int column) {
        columnButtons[column].setEnabled(false);
    }

    public void activateColumn(int column) {
        columnButtons[column].setEnabled(true);
    }

    public void showWinner(Player player) {
        JOptionPane.showMessageDialog(this.frame, player.getName() + " hat gewonnen.");
    }

}
