package connectfour.model;

import java.awt.Color;

public class NetworkPlayer extends Player {

	public NetworkPlayer(int id, String name, Color color) {
		super(id, name, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendThrow(int column) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNextThrow() {
		// TODO Auto-generated method stub
		return 0;
	}

}
