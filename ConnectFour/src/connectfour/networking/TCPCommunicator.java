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
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 */
public class TCPCommunicator {
    
    private InetAddress opponentAddr;
    
    public TCPCommunicator(String ipAddressOponent) {
        String[] stringArray = ipAddressOponent.split("/");
        try{
            opponentAddr = InetAddress.getByName(stringArray[1]);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }
    
    public void sendThrow(int column){
        try(Socket client = new Socket(opponentAddr, NetworkHelper.Port)){
            PrintWriter outStream = new PrintWriter(client.getOutputStream());
            outStream.println(column);
            outStream.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public int receiveThrow(){
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
    }

    public InetAddress getOpponentAddr(){
        return opponentAddr;
    }

    public void setOpponentAddr(InetAddress opponentAddr) {
        this.opponentAddr = opponentAddr;
    }       
}
