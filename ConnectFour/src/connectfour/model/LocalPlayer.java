package connectfour.model;

import java.awt.Color;

public class LocalPlayer extends Player {

	public LocalPlayer(int id, String name, Color color) {
		super(id, name, color);
	}

	@Override
	public void sendThrow(int column) {
		throw new IllegalStateException("Es ist nicht erlaubt einen Zug an einen Lokalen Spieler zu senden");
		
	}

	@Override
	public int getNextThrow() {
		throw new IllegalStateException("Es ist nicht erlaubt einen Zug von einem lokalen Spieler zu erwarten");
	}

}
