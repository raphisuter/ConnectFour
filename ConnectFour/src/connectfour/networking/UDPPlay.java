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
 */
public class UDPPlay extends Thread{
    
    private String ipAddress;
    
    public UDPPlay(String ipAddress){
        String[] stringArray = ipAddress.split("/");
        this.ipAddress = stringArray[1];
    }
    
    @Override
    public void run(){
        System.out.println("UDP-Connect");
        int i = 0;
        while(i <= 2){
            try(DatagramSocket socket = new DatagramSocket()){
                Thread.sleep(500);
                InetAddress address = InetAddress.getByName(ipAddress);
                byte[] raw = new byte[1000];
                raw = NetworkHelper.CONNECT_TO_SERVER.getBytes();
                DatagramPacket packet = new DatagramPacket(raw, raw.length, address, NetworkHelper.Port);
                socket.send(packet);
                System.out.println("Connect gesendet");
                i++;
            }catch(Exception e){
                System.err.println("Error: "+ e.getMessage());
                i++;
            }
        }
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
}
