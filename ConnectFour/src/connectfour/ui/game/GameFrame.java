/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.ui.game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public class GameFrame {
    
    private JFrame frame;
    
    public GameFrame() {
        createFrame();
 
        createLayout();
        setupLayout();
    }
    
    public void show() {
        frame.setVisible(true);
    }
    
    private void createFrame() {
        frame = new JFrame("Connect 4 - Game");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void createLayout() {
        LayoutManager layoutManager = new GridLayout(2, 1);
        frame.setLayout(layoutManager);
    }
    
    private void setupLayout() {
       // frame.add(singlePlayerButton);
       // frame.add(multiPlayerButton);
    }
   
    
}
