/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour;

import connectfour.ui.welcome.WelcomeController;
import connectfour.ui.welcome.WelcomeView;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 */
public class ConnectFour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Main Class here we start the game
        
        // 1. Herausfinden ob gegen Computer oder gegen Network Player
        // Dafür gibt es ein kleines UI
        System.out.println("Game is starting..."); 
        
        // Start Game - Es gibt eine Network und eine KI Implementation des Spiels
        WelcomeController controller = new WelcomeController();
        controller.showView();
        
    }
    
}
