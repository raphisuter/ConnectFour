/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.networking;

import java.net.InetAddress;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 */
public class TCPCommunicator {
    
    private InetAddress opponentAddr;
    
    public TCPCommunicator(String ipAddressOponent) {
        try{
            opponentAddr = InetAddress.getByName(ipAddressOponent);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void sendThrow(int column){
        
    }
    
    public int receiveThrow(){
        return 0;
    }
}
