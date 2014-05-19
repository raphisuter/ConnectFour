/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour.ki;

import connectfour.model.Player;
import connectfour.model.Stone;

/**
 *
 * @author Tom
 */
public interface KI {
    
    int getNextStone(int[][] gameField, Player you, Player enemy) throws FieldIsFullException;
    
}
