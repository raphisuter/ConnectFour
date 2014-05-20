/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.networking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 * 
 * Diese Klasse versendet via das Netzwerk so lange UDP Broadcasts, bis ein
 * Client sich verbindet oder ein Timeout entsteht
 */
public class UDPServer extends Thread{
    
    int maxAttemps;
    boolean hasOponent = false;
    
    public UDPServer(int maxAttemps) {
        this.maxAttemps = maxAttemps;
    }
    
    @Override
    public void run(){
        int countOfAttemps = 1;
        System.out.println("Starte UDP-Broadcast");
        //Versuche so lange einen Server zu erreichen, bis Antwort oder
        //maxAttemps grösser als countOfAttemps
        while(maxAttemps >= countOfAttemps){
            try(DatagramSocket socket = new DatagramSocket()){
                String broadcast = "255.255.255.255";
                InetAddress address = InetAddress.getByName(broadcast);
                byte[] raw = new byte[1000];
                raw = NetworkHelper.SEARCH_SERVER.getBytes();
                DatagramPacket packet = new DatagramPacket(raw, raw.length, address, 12345);
                socket.send(packet);
                countOfAttemps++;
                //Sende alle 2 Sekunden eine Broadcast Meldung
                Thread.sleep(2000);
            }catch(Exception e){
                System.err.println("Error: "+ e.getMessage());
            }
        }
    }
}
