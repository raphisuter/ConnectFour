/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.ui.welcome;

import javax.swing.JButton;

/**
 *
 * @author Markus
 */
public class WelcomeModel {

    private boolean playComputer;
    
    private boolean playHuman;
    
    private String playerName;
    
    
    
    public WelcomeModel()
    {
    
    }
    
    
    
    /**
     * Setter-Methods
     * @return 
     */
    public void setPlayComputer(boolean setComputer)
    {
        playComputer = setComputer;
    }
    
    public void setPlayHuman(boolean setHuman)
    {
        playComputer = setHuman;
    }
    
    public void setPlayerName(String setName)
    {
        playerName = setName;
    }
    
    /**
     * Getter Methods
     */
    public boolean getPlayComputer()
    {
        return playComputer;
    }
    
    public boolean getPlayHuman()
    {
        return playHuman;
    }
    
    public String getPlayerName()
    {
        return playerName;
    }
    
}
