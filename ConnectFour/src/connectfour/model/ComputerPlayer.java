package connectfour.model;

import java.awt.Color;

import connectfour.ki.FieldIsFullException;
import connectfour.ki.KI;
import connectfour.ki.KIMedium;

public class ComputerPlayer extends Player {

    private KI ki;
    
    private int[][] theArray;
    
    int maxRow = 0;
    
    int lastRow = 0;
    
    ComputerPlayer(int id, String name, Color color, int cols, int rows, KI ki) {
        super(id, name, color);
        super.setName("Computer");
        this.ki = ki;
        this.maxRow = rows;
        this.theArray = new int[cols][this.maxRow];
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
        int column = 0;
        try {
            column = ki.getNextStone(theArray, null, null);
        } catch (FieldIsFullException e) {
            throw new RuntimeException(e.getMessage());
        }
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return column;
    }
}
