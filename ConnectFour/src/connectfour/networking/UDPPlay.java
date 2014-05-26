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
 * In dieser Klasse sendet ein Client, welcher einen Server zum Spielen
 * ausgewählt hat, dem Server eine Nachricht, so dass beide Seiten die IP des
 * Gegners wissen
 */
public class UDPPlay extends Thread {

    private String ipAddress;

    //Konstruktor
    public UDPPlay(String ipAddress) {
        String[] stringArray = ipAddress.split("/");
        this.ipAddress = stringArray[1];
    }

    @Override
    public void run() {
        System.out.println("UDP-Connect an Server senden");
        int i = 0;
        //Es werden 3 Nachrichten gesendet
        while (i <= 2) {
            try (DatagramSocket socket = new DatagramSocket()) {
                //Ein sleep, so dass die Nachrichten zeitversetzt gesendet werden
                Thread.sleep(300);
                InetAddress address = InetAddress.getByName(ipAddress);
                byte[] raw = new byte[1000];
                //Nachricht zusammen stellen
                raw = NetworkHelper.CONNECT_TO_SERVER.getBytes();
                DatagramPacket packet = new DatagramPacket(raw, raw.length, address, NetworkHelper.Port);
                socket.send(packet);
                i++;
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                i++;
            }
        }
    }

    //Getter und Setter
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}
