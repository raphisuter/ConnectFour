/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour;

import connectfour.ui.welcome.WelcomeFrame;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 */
public class ConnectFour {

    private int[][] theArray;

    private int maxRow = 6;     // Default 6: Durch User Anpassbar
    private int maxCol = 7;     // Default 7: Durch User Anpassbar

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Main Class here we start the game
        
        // 1. Herausfinden ob gegen Computer oder gegen Network Player
        // Dafür gibt es ein kleines UI
        System.out.println("Game is starting..."); 
        
        // Start Game - Es gibt eine Network und eine KI Implementation des Spiels
        WelcomeFrame frame = new WelcomeFrame();
        frame.show();
        
    }

    public int getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(int maxRow) {
        this.maxRow = maxRow;
    }

    public int getMaxCol() {
        return maxCol;
    }

    public void setMaxCol(int maxCol) {
        this.maxCol = maxCol;
    }

    /**
     * Prüft ob das Spiel gewonnen wurde.
     * Die Methode displayWinner muss noch im GUI gemacht werden.
     */
    public void check4() {
        // Horizontale Prüfung
        for (int row=0; row<maxRow; row++) {
            for (int col=0; col<maxCol-3; col++) {
                int curr = theArray[row][col];
                if (curr>0
                        && curr == theArray[row][col+1]
                        && curr == theArray[row][col+2]
                        && curr == theArray[row][col+3]) {
                    //displayWinner
                }
            }
        }
        // Vertikale Prüfung
        for (int col=0; col<maxCol; col++) {
            for (int row=0; row<maxRow-3; row++) {
                int curr = theArray[row][col];
                if (curr>0
                        && curr == theArray[row+1][col]
                        && curr == theArray[row+2][col]
                        && curr == theArray[row+3][col]) {
                    //displayWinner
                }
            }
        }
        // Diagonale unten links nach oben rechts
        for (int row=0; row<maxRow-3; row++) {
            for (int col=0; col<maxCol-3; col++) {
                int curr = theArray[row][col];
                if (curr>0
                        && curr == theArray[row+1][col+1]
                        && curr == theArray[row+2][col+2]
                        && curr == theArray[row+3][col+3]) {
                    //displayWinner
                }
            }
        }
        // Diagonale oben links nach unten rechts
        for (int row=maxRow-1; row>=3; row--) {
            for (int col=0; col<maxCol-3; col++) {
                int curr = theArray[row][col];
                if (curr>0
                        && curr == theArray[row-1][col+1]
                        && curr == theArray[row-2][col+2]
                        && curr == theArray[row-3][col+3]) {
                    //displayWinner
                }
            }
        }
    } // end check4
    
}
