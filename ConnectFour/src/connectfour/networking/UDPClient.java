/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.networking;

import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 */
public class UDPClient extends Thread{
    
    private List<String> clientAddressList;
    private boolean timeout;
    
    public UDPClient(){
        //Beim erzeugen des UDPClients variablen initialisieren
        clientAddressList = new ArrayList<String>();
        timeout = false;
    }
    
    @Override
    public void run(){
        try(DatagramSocket socket = new DatagramSocket(12345)){
            byte[] buf = new byte[1000];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            
            //Timeout festlegen (40 Sekunden)
            socket.setSoTimeout(40000);
            String data = "";
            // recieve data until timeout
            while(true){      
                try {
                    socket.receive(packet);
                    data = new String(packet.getData(), 0, packet.getLength());
                    //Nur wenn UDP Anfrage von unserem Spiel, offenen Server in Liste aufnehmen
                    if(data.equals(NetworkHelper.SEARCH_SERVER)){
                        System.out.println(packet.getAddress()+ " is a ConnectFour Server");
                        if(!this.clientAddressList.contains(packet.getAddress().toString()))
                            this.clientAddressList.add(packet.getAddress().toString());
                    }
                }
                catch (SocketTimeoutException e) {
                    // timeout exception.
                    System.out.println("Timeout reached");
                    
                }
            }             
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

    public boolean isTimeout() {
        return timeout;
    }

    public void setTimeout(boolean timeout) {
        this.timeout = timeout;
    }
}
