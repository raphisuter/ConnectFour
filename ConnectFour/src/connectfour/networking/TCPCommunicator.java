/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 */
public class TCPCommunicator {
    
    private InetAddress opponentAddr;
    
    public TCPCommunicator(String ipAddressOponent) {
        if(ipAddressOponent.contains("/")){
            String [] addr = ipAddressOponent.split("/");
            ipAddressOponent = addr[1];
        }

        try{
            opponentAddr = InetAddress.getByName(ipAddressOponent);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }
    
    public void sendThrow(int column){
        /*try(Socket client = new Socket(opponentAddr, NetworkHelper.Port)){
            PrintWriter outStream = new PrintWriter(client.getOutputStream());
            outStream.println(column);
            outStream.flush();
        }catch(IOException e){
            e.printStackTrace();
        }*/
        
        try (Socket sock = new Socket(opponentAddr, NetworkHelper.Port)){
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            //Output
            out.println(column);
            out.flush();

            out.close();
            sock.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public int receiveThrow(){
        /*
        try(Socket client = new Socket(opponentAddr, NetworkHelper.Port)){
            BufferedReader inStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String line;
            while((line = inStream.readLine()) != null){
                return Integer.parseInt(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return 0;
        */
        
        try (ServerSocket serverSock = new ServerSocket(NetworkHelper.Port)){
            //Get connection
            Socket clientSock = serverSock.accept();
            System.out.println("Connected client");

            //Get input
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
            int ret = (Integer.parseInt(br.readLine()));

            br.close();
            serverSock.close();
            clientSock.close();
            return ret;
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public InetAddress getOpponentAddr(){
        return opponentAddr;
    }

    public void setOpponentAddr(InetAddress opponentAddr) {
        this.opponentAddr = opponentAddr;
    }       
}
