package bomberman;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertNotEquals;

public class UuidTest {

    UUID uuid1;
    UUID uuid2;

    @Before
    public void setUp() {
        uuid1 = UUID.randomUUID();
        uuid2 = UUID.randomUUID();
    }

    @Test
    public void uuidRandomWorkingProperly() {
        assertNotEquals(uuid1, uuid2);
        assertNotEquals(uuid1, UUID.randomUUID());
    }
}
