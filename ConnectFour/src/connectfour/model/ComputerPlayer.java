package connectfour.model;

import java.awt.Color;

import connectfour.ki.FieldIsFullException;
import connectfour.ki.KI;
import connectfour.ki.KIHard;
import connectfour.ki.KISimple;

public class ComputerPlayer extends Player {

	private int[][] theArray;
	
	
	public ComputerPlayer(int id, String name, Color color) {
		super(id, name, color);
		super.setName("Computer");
		

		this.theArray = new int[6][7];
	}

	@Override
	public void sendThrow(int column) {
			int maxRow = 7;
			int lastRow = 0;
	        for (int row=1; row<maxRow+1; row++) {
	            if (!(this.theArray[column-1][row-1]>0)){
	                lastRow = row;
	                break;
	            }
	        }
	    
	    
	            theArray[column-1][lastRow-1] = 1;
	          
	          
	          
		
	}

	@Override
	public int getNextThrow() {
		KI ki = new KIHard();
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
