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
public class UDPGetIp{
    
    private boolean ipReceived;
    
    public UDPGetIp(){
        ipReceived = false;
    }
    
    public String getIp(){
        String ip = "";
        try(DatagramSocket socket = new DatagramSocket(NetworkHelper.Port)){
            byte[] buf = new byte[1000];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            
            //Timeout festlegen (40 Sekunden)
            socket.setSoTimeout(40000);
            String data = "";
            // recieve data until timeout
            while(!ipReceived){
                try {
                    socket.receive(packet);
                    data = new String(packet.getData(), 0, packet.getLength());
                    //Nur wenn UDP Anfrage von unserem Spiel, offenen Server in Liste aufnehmen
                    if(data.contains(NetworkHelper.CONNECT_TO_SERVER)){
                        String[] stringArray = packet.getAddress().toString().split("/");
                        ip = stringArray[1];
                        ipReceived = true;
                    }
                }
                catch (SocketTimeoutException e) {
                    // timeout exception.
                    System.out.println("Timeout reached");
                    return null;
                }
            }
            System.out.println("UDPGetIp geschlossen");
        }catch(Exception e){
            System.err.println("Error: "+ e.getMessage());
            return null;
        }
        return ip;
    }

    public boolean isIpReceived() {
        return ipReceived;
    }

    public void setIpReceived(boolean ipReceived) {
        this.ipReceived = ipReceived;
    }
    
}
