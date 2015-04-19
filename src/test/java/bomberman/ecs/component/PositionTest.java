package bomberman.ecs.component;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PositionTest {

    Position position;

    @Before
    public void setPosition() {
        position = new Position(0,0);
    }

    @Test
    public void isPositionFinal() {
        position.x = 2;

        assertTrue(position.x == 2);
    }

}