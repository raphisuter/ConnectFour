/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.network;

import connectfour.model.LocalPlayer;
import connectfour.model.Player;
import connectfour.networking.TCPCommunicator;
import java.awt.Color;
import java.net.InetAddress;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Suter Raphael <raphael.suter@stud.hslu.ch>
 */
public class TCPCommunicatorTest {
    private TCPCommunicator comm;
    private InetAddress addr;
    @Before
    public void setUp() {
        comm = new TCPCommunicator("Gestho - /192.168.1.103");
        
        try{
            this.addr = InetAddress.getByName("192.168.1.103");
        }catch(Exception e){
            
        }
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(addr, comm.getOpponentAddr());
    }
}
