
package connectfour.logic;

import connectfour.model.Player;
import connectfour.model.Stone;

/**
 *
 * @author Alex
 */
public interface ConnectFourLogicChangeListener {
    
    void changedCurrentPlayer(Player changePlayer);
    
    void addedNewStone(Stone stone);
    
    void notifyWinner(Player player);
    
    void notifyColumnIsFull(int column);
    
}
