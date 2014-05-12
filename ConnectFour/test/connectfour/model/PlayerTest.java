package connectfour.model;

import java.awt.Color;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player testee;

    @Before
    public void setUp() {
        testee = new Player(4, "Ingold", Color.GRAY);
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(4, testee.getId());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Ingold", testee.getName());
    }

    @Test
    public void testGetColor() {
        Assert.assertEquals(Color.GRAY, testee.getColor());
    }

}
