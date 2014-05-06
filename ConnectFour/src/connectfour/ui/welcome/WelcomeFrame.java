/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.ui.welcome;

import connectfour.ui.game.GameFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public class WelcomeFrame {
    
    private static final String FRAME_TITLE = "Connect 4 - Welcome";
    
    private static final String BUTTON_SINGLE_PLAYER = "Einzelspieler";
    
    private static final String BUTTON_MULTI_PLAYER = "Mehrspieler";
    
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
    }
    
    private void createLayout() {
        //LayoutManager layoutManager = new GridLayout(2, 1);
        LayoutManager layoutManager = new BorderLayout(10, 10);
        frame.setLayout(layoutManager);
    }
    
    private void setupLayout() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(singlePlayerButton);
        panel.add(multiPlayerButton);
        frame.add(panel, BorderLayout.CENTER);
    }
    
    private void createSinglePlayerButton() {
        singlePlayerButton = new JButton(BUTTON_SINGLE_PLAYER);
        singlePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Destroy this window and create the game window
                System.out.println("Clicked on single player");
                
                frame.setVisible(false);
                
                GameFrame gameFrame = new GameFrame();
                gameFrame.show();
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
