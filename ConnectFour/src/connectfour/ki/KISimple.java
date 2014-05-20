package connectfour.ki;

import connectfour.model.Player;

/**
 *
 * @author Tom
 */
public class KISimple implements KI {

    @Override
    public int getNextStone(int[][] gameField, Player you, Player enemy) throws FieldIsFullException {
        
        for (int c = 0; c < gameField.length; c++) {
            int rowCount = gameField[c].length;
            
            if (gameField[c][rowCount-1] == 0) {  //Prüfung für leeres Feld
                return c + 1;  //c ist der index
            }
        }
        throw new FieldIsFullException();
    }
    
    @Override
    public String toString() {
        return "Schwach";
    }
    
}
