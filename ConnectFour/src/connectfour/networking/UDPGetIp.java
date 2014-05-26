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
 *
 * Diese Klasse wird nur von einem Server (Spieler der Spiel eröffnet gebraucht
 * Sobald der Server seine UDP Meldungen im Netz sendet, wird diese Klasse
 * erstellt und sie warted auf einen Gegenspieler, welcher eine bestimmte
 * Nachricht an den Server senden
 */
public class UDPGetIp {

    private boolean ipReceived;

    //Konstruktor
    public UDPGetIp() {
        ipReceived = false;
    }

    /*Methode empfängt solange Meldungen aus dem Netz bis ein Gegenspieler
     spielen will. Dann wird dessen IP zurück gegeben */
    public String getIp() {
        String ip = "";
        //Try with Resources
        try (DatagramSocket socket = new DatagramSocket(NetworkHelper.Port)) {
            byte[] buf = new byte[1000];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            //Timeout festlegen (40 Sekunden)
            socket.setSoTimeout(40000);
            String data = "";
            //Daten Empfangen bis Meldung erhalten
            while (!ipReceived) {
                try {
                    socket.receive(packet);
                    data = new String(packet.getData(), 0, packet.getLength());
                    //Nur wenn UDP Anfrage von Gegenspieler, IP Addresse zurück geben
                    if (data.contains(NetworkHelper.CONNECT_TO_SERVER)) {
                        String[] stringArray = packet.getAddress().toString().split("/");
                        ip = stringArray[1];
                        ipReceived = true;
                    }
                } catch (SocketTimeoutException e) {
                    // timeout exception.
                    System.out.println("Timeout reached");
                    return null;
                }
            }
            System.out.println("UDPGetIp geschlossen");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
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
