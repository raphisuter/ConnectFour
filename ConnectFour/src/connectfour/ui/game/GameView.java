package connectfour.ui.game;

import connectfour.logic.ConnectFourLogicChangeListener;
import connectfour.model.Player;
import connectfour.model.Stone;
import connectfour.ui.util.CenterWindowUtil;
import connectfour.ui.util.JLableCircle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Präsentiert die Spielansicht.
 *
 * @author Alex
 */
public class GameView {

    private ConnectFourLogicChangeListener listener;
    
    private final int columns;

    private final int rows;
    
    private JFrame frame;

    private JMenuBar menuBar;

    private JMenu menuGame;

    private JMenuItem menuItemRestart;

    private JMenuItem menuItemClose;

    private JButton[] columnButtons;

    private JLableCircle[][] stoneLabels;

    private JLabel lblPlayer1Color;

    private JLabel lblPlayer2Color;

    private JLabel lblPlayer1Name;

    private JLabel lblPlayer2Name;

    public GameView(Player player1, Player player2, int columns, int rows) {
        this.columns = columns;
        this.rows = rows;

        createFrame();
        createMenu();
        createButtons();
        createLabels(player1, player2);
        setupLayout();
    }

    public void show() {
        frame.setVisible(true);
    }
    
    public void close() {
        this.frame.setVisible(false);
        this.frame.dispose();
    }

    public void addActionListenerToAllButtons(ActionListener listener) {
        for (JButton button : this.columnButtons) {
            button.addActionListener(listener);
        }
    }
    
    public void addActionListenerClose(ActionListener listener) {
        menuItemClose.addActionListener(listener);
    }

    public void addActionListenerRestart(ActionListener listener) {
        menuItemRestart.addActionListener(listener);
    }

    private void createFrame() {
        int width = this.columns * 70;
        int height = 125 + this.rows * 64;
        
        frame = new JFrame("Connect 4 - Game");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        CenterWindowUtil.center(frame);
    }
    
    private void createMenu() {
        menuBar = new JMenuBar();

        menuGame = new JMenu("Game");

        menuItemRestart = new JMenuItem("Neu starten");
        menuItemClose = new JMenuItem("Beenden");

        menuBar.add(menuGame);
        menuGame.add(menuItemRestart);
        menuGame.add(menuItemClose);
    }
    
    private void createButtons() {
        columnButtons = new JButton[columns];
        for (int i = 0; i < columnButtons.length; i++) {
            columnButtons[i] = new JButton();
            columnButtons[i].setActionCommand(String.valueOf(i + 1));
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

        stoneLabels = new JLableCircle[columns][rows];
        for (int c = 0; c < stoneLabels.length; c++) {
            for (int r = 0; r < stoneLabels[c].length; r++) {
                stoneLabels[c][r] = new JLableCircle();
                stoneLabels[c][r].setBackground(Color.white);
                stoneLabels[c][r].setOpaque(true);
            }
        }
    }
    
    private void setupLayout() {
        frame.setLayout(new BorderLayout());

        frame.getContentPane().add(menuBar, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.lblPlayer1Name.setBounds(30, 12, 100, 30);
        panel.add(lblPlayer1Name);

        this.lblPlayer2Name.setBounds(30, 32, 100, 30);
        panel.add(lblPlayer2Name);

        this.lblPlayer1Color.setBounds(10, 20, 15, 15);
        panel.add(lblPlayer1Color);

        this.lblPlayer2Color.setBounds(10, 40, 15, 15);
        panel.add(lblPlayer2Color);

        int i = 0;
        for (JButton button : this.columnButtons) {
            button.setBounds(10 + i * 70, 70, 45, 30);
            panel.add(button);
            i++;
        }

        for (int c = 0; c < stoneLabels.length; c++) {
            for (int r = stoneLabels[c].length - 1; r >= 0; r--) {
                
               
                int lastIndexOfRow = stoneLabels[c].length - 1;
                int indexRowToTake = lastIndexOfRow - r;
                
                JLabel lbl = stoneLabels[c][indexRowToTake];
                lbl.setBounds(10 + c * 70, 125 + r * 55, 45, 45);
                panel.add(lbl);
            }
        }

        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
    
    private void updateCurrentPlayer(Player player) {
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

    private void showWinner(Player player) {
        JOptionPane.showMessageDialog(this.frame, player.getName() + " hat gewonnen.");
    }

    private void addStone(Stone stone) {
        stoneLabels[stone.getColumn() - 1][stone.getRow() - 1].setBackground(stone.getPlayer().getColor());
    }

    public ConnectFourLogicChangeListener getConnectFourLogicChangeListener() {
        if (listener == null) {
            listener = new ConnectFourLogicChangeListener() {

                @Override
                public void changedCurrentPlayer(Player changePlayer) {
                    updateCurrentPlayer(changePlayer);
                }

                @Override
                public void addedNewStone(Stone stone) {
                    addStone(stone);
                }
                
                @Override
                public void notifyWinner(Player winner) {
                    showWinner(winner);
                    close();
                }
                
                @Override
                public void notifyColumnIsFull(int column) {
                    int indexColumn = column - 1;
                    columnButtons[indexColumn].setEnabled(false);
                }
            };
        }
        return listener;
    }

}
