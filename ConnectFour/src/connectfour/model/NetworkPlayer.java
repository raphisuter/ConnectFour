package connectfour.model;

import connectfour.networking.TCPCommunicator;
import java.awt.Color;
import java.net.InetAddress;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 */
public class NetworkPlayer extends Player {
        
        private TCPCommunicator comm;
        
	public NetworkPlayer(int id, String name, Color color, String ipAddress) {
		super(id, name, color);
                //IP-Adresse in Networkplayer ablegen
                this.comm = new TCPCommunicator(ipAddress);
	}

	@Override
	public void sendThrow(int column) {
		comm.sendThrow(column);
	}

	@Override
	public int getNextThrow() {
		int i = comm.receiveThrow();
		return i;
	}
        
}
