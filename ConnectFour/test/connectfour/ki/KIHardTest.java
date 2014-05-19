package connectfour.ki;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tom
 */
public class KIHardTest {

    private KIHard ki;

    @Before
    public void setUp() {
        ki = new KIHard();
    }

   /*  @Test
   public void testKiEmptyField() {
        int[][] gameField = new int[6][6];
        try {
            int column = ki.getNextStone(gameField, null, null);
            Assert.assertEquals("Kolonne stimmt nicht", 1, column);
        } catch (FieldIsFullException e) {
            Assert.fail("Feld ist nicht voll!!!");
        }
    }*/

    @Test
    public void testKiFirstColumnIsFull() {
        int[][] gameField = new int[2][6];
        for (int r = 0; r < gameField[0].length; r++) {
            gameField[0][r] = 100;
        }
        try {
            int column = ki.getNextStone(gameField, null, null);
            Assert.assertEquals("Kolonne stimmt nicht", 2, column);
        } catch (FieldIsFullException e) {
            Assert.fail("Feld ist nicht voll!!!");
        }
    }

    @Test
    public void testKiFieldIsFull() {
        int[][] gameField = new int[6][6];
        for (int c = 0; c < gameField.length; c++) {
            for (int r = 0; r < gameField[c].length; r++) {
                gameField[c][r] = 100;
            }
        }
            try {
                int column = ki.getNextStone(gameField, null, null);
                Assert.fail("Feld wäre voll!!!");
            } catch (FieldIsFullException e) {
                
            }
        }
    }
