/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour.networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 *
 * Diese Klasse ist für den Netzwerkverkehr während des Spiels zuständig. Es
 * muss die Addresse des Gegners abgelegt werden und es können Steine gesendet
 * und empfangen werden
 */
public class TCPCommunicator {

    private InetAddress opponentAddr;

    //Konstruktor inklusiv Addressparser
    public TCPCommunicator(String ipAddressOponent) {
        if (ipAddressOponent.contains("/")) {
            String[] addr = ipAddressOponent.split("/");
            ipAddressOponent = addr[1];
        }

        //Addresse auflösen und Ablegen
        try {
            opponentAddr = InetAddress.getByName(ipAddressOponent);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    //Diese Methode senden einen Zug an den Gegenspieler
    /*
     Ein Socket wird mithilfe der Addresse und dem Port erstellt und
     anschliessend wird der Zug an den Gegner gesendet
     */
    public void sendThrow(int column) {
        try (Socket sock = new Socket(opponentAddr, NetworkHelper.Port)) {
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            //Output
            out.println(column);
            out.flush();

            out.close();
            sock.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Diese Methode empfängt den Zug des Gegenspielers
    /*
     Es wird ein Socket erstellt und anschliessend auf einem Port auf den
     Input gewarted. Da es kein Thread ist, wird in dieser Methode gewarted
     bis ein Stein empfangen wird
     */
    public int receiveThrow() {
        int retValue = 0;
        try (ServerSocket serverSock = new ServerSocket(NetworkHelper.Port)) {
            try (Socket clientSock = serverSock.accept()) {
                //Get input
                BufferedReader br = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
                retValue = (Integer.parseInt(br.readLine()));

                br.close();

                clientSock.close();
            } catch (Exception eo) {
                //eo.printStackTrace();
                retValue = 0;
            }
            serverSock.close();
        } catch (Exception e) {
            //e.printStackTrace();
            retValue = 0;
        }
        return retValue;
    }

    //Getter und Setter
    public InetAddress getOpponentAddr() {
        return opponentAddr;
    }

    public void setOpponentAddr(InetAddress opponentAddr) {
        this.opponentAddr = opponentAddr;
    }
}
