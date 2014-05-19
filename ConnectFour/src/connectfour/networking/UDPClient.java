/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.networking;

import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 */
public class UDPClient extends Thread{
    
    String clientAddress;
    
    @Override
    public void run(){
        while(true){
            try(DatagramSocket socket = new DatagramSocket(12345)){
                byte[] buf = new byte[1000];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                sleep(10);
                //Nur wenn UDP Anfrage korrekt, auf diese Antworten
                String data = new String(packet.getData(), 0, packet.getLength());
                if(data.equals(NetworkHelper.SEARCH_SERVER)){
                    System.out.println(packet.getAddress()+ " is a ConnectFour Server");
                    this.clientAddress = packet.getAddress().toString();
                }              
            }catch(Exception e){
                System.err.println("Error: "+ e.getMessage());
            }
        }
    }
}
