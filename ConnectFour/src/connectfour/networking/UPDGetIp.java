/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.networking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 */
public class UPDGetIp{
    
    public String getIp(){
        String ip = "";
        try(DatagramSocket socket = new DatagramSocket(NetworkHelper.Port)){
            byte[] buf = new byte[1000];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            
            //Timeout festlegen (8 Sekunden)
            socket.setSoTimeout(8000);
            String data = "";
            // recieve data until timeout
            
            try {
                socket.receive(packet);
                data = new String(packet.getData(), 0, packet.getLength());
                //Nur wenn UDP Anfrage von unserem Spiel, offenen Server in Liste aufnehmen
                if(data.contains(NetworkHelper.CONNECT_TO_SERVER)){
                    ip = packet.getAddress().toString();
                }
            }
            catch (SocketTimeoutException e) {
                // timeout exception.
                System.out.println("Timeout reached");
                return null;
            }
            System.out.println("Client geschlossen");
        }catch(Exception e){
            System.err.println("Error: "+ e.getMessage());
            return null;
        }
        return ip;
    }
}
