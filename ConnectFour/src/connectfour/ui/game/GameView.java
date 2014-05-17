package connectfour.ui.game;

import connectfour.logic.ConnectFourLogicChangeListener;
import connectfour.model.Player;
import connectfour.model.Stone;
import connectfour.ui.util.CenterWindowUtil;
import connectfour.ui.util.JButtonCircle;
import connectfour.ui.util.JLabelCircle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.border.EmptyBorder;

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

    private JButtonCircle[] columnButtons;

    private JLabelCircle[][] stoneLabels;

    private JLabel lblPlayer1Color;

    private JLabel lblPlayer2Color;

    private JLabel lblPlayer1Name;

    private JLabel lblPlayer2Name;
    
    private Player currentPlayer;
    
    private Color backgroundColor = new Color(245, 245, 245);

    public GameView(Player player1, Player player2, int columns, int rows) {
        this.currentPlayer = player1;
        
        this.columns = columns;
        this.rows = rows;

        createFrame();
        createMenu();
        createButtons();
        createLabels(player1, player2);
        setupLayout();
    }

    public void show() {
        frame.pack();
        CenterWindowUtil.center(frame);
        frame.setVisible(true);
        
    }

    public void close() {
        this.frame.setVisible(false);
        this.frame.dispose();
    }

    public void addActionListenerToAllButtons(ActionListener listener) {
        for (JButtonCircle button : this.columnButtons) {
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
        frame = new JFrame("Connect 4 - Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
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
        columnButtons = new JButtonCircle[columns];
        for (int i = 0; i < columnButtons.length; i++) {
            final JButtonCircle button = new JButtonCircle();
            columnButtons[i] = button;
            button.setBackground(backgroundColor);
            button.setForeground(Color.lightGray);
            columnButtons[i].setActionCommand(String.valueOf(i + 1));
            
            columnButtons[i].addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent event) {
                    button.setForeground(currentPlayer.getColor());
                }
                
                @Override
                public void mouseExited(MouseEvent event) {
                    button.setForeground(Color.lightGray);
                }
                
            });
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

        stoneLabels = new JLabelCircle[columns][rows];
        for (int c = 0; c < stoneLabels.length; c++) {
            for (int r = 0; r < stoneLabels[c].length; r++) {
                stoneLabels[c][r] = new JLabelCircle();
                stoneLabels[c][r].setBackground(backgroundColor);
            }
        }
    }

    private void setupLayout() {

        Dimension dimensionStone = new Dimension(50, 50);
        
        JPanel panelPlayersColors = new JPanel();
        panelPlayersColors.setLayout(new GridLayout(2, 1, 5, 5));
        panelPlayersColors.setBorder(new EmptyBorder(0, 0, 0, 10) );
        panelPlayersColors.setBackground(backgroundColor);
        lblPlayer1Color.setPreferredSize(new Dimension(20, 20));
        lblPlayer2Color.setPreferredSize(new Dimension(20, 20));
        panelPlayersColors.add(lblPlayer1Color);
        panelPlayersColors.add(lblPlayer2Color);
        
        JPanel panelPlayersNames = new JPanel();
        panelPlayersNames.setLayout(new GridLayout(2, 1, 5, 5));
        panelPlayersNames.setBackground(backgroundColor);
        panelPlayersNames.add(lblPlayer1Name);
        panelPlayersNames.add(lblPlayer2Name);
        
        JPanel panelPlayers = new JPanel();
        panelPlayers.setLayout(new BorderLayout());
        panelPlayers.setBackground(backgroundColor);
        panelPlayers.setBorder(new EmptyBorder(10, 10, 10, 10) );
        panelPlayers.add(panelPlayersColors, BorderLayout.WEST);
        panelPlayers.add(panelPlayersNames, BorderLayout.CENTER);

        // Panel Buttons
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(1, columns, 10, 10));
        panelButtons.setBorder(new EmptyBorder(10, 10, 10, 10) );
        panelButtons.setBackground(backgroundColor);
        for (JButtonCircle button : this.columnButtons) {
            button.setPreferredSize(dimensionStone);
            panelButtons.add(button);
        }

        // Panel Labels
        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new GridLayout(rows, columns, 10, 10));
        panelLabels.setBackground(Color.BLUE);
        panelLabels.setBorder(new EmptyBorder(10, 10, 10, 10) );
        for (int r = rows -1; r >= 0; r--) {
            for (int c = 0; c < columns; c++) {
                JLabelCircle label = stoneLabels[c][r];
                label.setPreferredSize(dimensionStone);
                panelLabels.add(label);
            }
        }

        // Panel Field
        JPanel panelField = new JPanel();
        panelField.setLayout(new BorderLayout());
        panelField.add(panelButtons, BorderLayout.NORTH);
        panelField.add(panelLabels, BorderLayout.CENTER);

        // Panel Gamefield
        JPanel panelGameField = new JPanel();
        panelGameField.setLayout(new BorderLayout());
        panelGameField.add(panelPlayers, BorderLayout.NORTH);
        panelGameField.add(panelField, BorderLayout.CENTER);

        // Frame
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(menuBar, BorderLayout.NORTH);
        frame.getContentPane().add(panelGameField, BorderLayout.CENTER);
    }

    private void updateCurrentPlayer(Player player) {
        this.currentPlayer = player;
        
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
    
    private void showNoWinner() {
        JOptionPane.showMessageDialog(this.frame, "Unentschieden!");
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
                    columnButtons[indexColumn].setVisible(false);
                }
               
                @Override
                public void gameFinishedNoWinner() {
                    showNoWinner();
                    close();
                }
                
            };
        }
        return listener;
    }

}
