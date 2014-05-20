/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.networking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 */
public class UDPClient extends Thread{
    
    private List<String> clientAddressList;
    private boolean stopThread;
    
    public UDPClient(){
        //Beim erzeugen des UDPClients variablen initialisieren
        clientAddressList = new ArrayList<String>();
        stopThread = false;
    }
    
    @Override
    public void run(){
        try(DatagramSocket socket = new DatagramSocket(NetworkHelper.Port)){
            byte[] buf = new byte[1000];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            
            //Timeout festlegen (40 Sekunden)
            socket.setSoTimeout(40000);
            String data = "";
            // recieve data until timeout
            while(!stopThread){
                try {
                    socket.receive(packet);
                    data = new String(packet.getData(), 0, packet.getLength());
                    //Nur wenn UDP Anfrage von unserem Spiel, offenen Server in Liste aufnehmen
                    if(data.contains(NetworkHelper.SEARCH_SERVER)){
                        System.out.println(packet.getAddress()+ " is a ConnectFour Server");
                        if(!this.clientAddressList.contains(data.substring(33) + " - " +  packet.getAddress().toString()))
                            this.clientAddressList.add(data.substring(33) + " - " + packet.getAddress().toString());
                    }
                }
                catch (SocketTimeoutException e) {
                    // timeout exception.
                    System.out.println("Timeout reached");
                    
                }
            }
            System.out.println("Client geschlossen");
        }catch(Exception e){
            System.err.println("Error: "+ e.getMessage());
        }
    }
    
    /*          Getter und Setter            */
    public List<String> getClientAddressList() {
        return clientAddressList;
    }

    public void setClientAddressList(List<String> clientAddressList) {
        this.clientAddressList = clientAddressList;
    }

    public boolean isStopThread() {
        return stopThread;
    }

    public void setStopThread(boolean stopThread) {
        this.stopThread = stopThread;
    }
}
