/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inttest.connectfour.ui.searchServer;

import connectfour.ui.searchServer.SearchServerController;

/**
 *
 * @author Markus
 */
public class TestMain {
    
    public static void main(String[] args) {
        SearchServerController controller = new SearchServerController(null);
        
        controller.showView();
    }
    
}
