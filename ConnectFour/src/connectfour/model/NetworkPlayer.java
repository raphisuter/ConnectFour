package connectfour.model;

import connectfour.networking.TCPCommunicator;
import java.awt.Color;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 *
 * Diese Klasse erbt von Player, überschreibt dessen Methoden sendThrow und
 * getNextThrow und verwendet in diesen Methoden den {@link TCPCommunicator}
 */
public class NetworkPlayer extends Player {

    private TCPCommunicator comm;

    //Konstruktor inkl Initialisierung des TCPCommunicators
    NetworkPlayer(int id, String name, Color color, String ipAddress) {
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
        return comm.receiveThrow();
    }
}
