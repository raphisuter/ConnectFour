package connectfour.model;

import java.awt.Color;

import connectfour.ki.FieldIsFullException;
import connectfour.ki.KI;
import connectfour.ki.KIMedium;
import connectfour.ki.KISimple;
import connectfour.ui.welcome.WelcomeView;

public class ComputerPlayer extends Player {

    private int[][] theArray;
    int maxRow = 0;
    int lastRow = 0;
    
    WelcomeView welcomeView;

    public ComputerPlayer(int id, String name, Color color, WelcomeView welcomeView) {
        super(id, name, color);
        super.setName("Computer");
        this.welcomeView = welcomeView;
        this.maxRow = welcomeView.getRows();
        this.theArray = new int[welcomeView.getColumns()][this.maxRow];
    }

    @Override
    public void sendThrow(int column) {

        for (int row = 1; row < maxRow + 1; row++) {
            if (!(this.theArray[column - 1][row - 1] > 0)) {
                lastRow = row;
                break;
            }
        }


        theArray[column - 1][lastRow - 1] = 1;




    }

    @Override
    public int getNextThrow() {
        KI ki = new KIMedium();
        int column = 0;
        try {
            column = ki.getNextStone(theArray, this, null);
        } catch (FieldIsFullException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return column;

    }
}
