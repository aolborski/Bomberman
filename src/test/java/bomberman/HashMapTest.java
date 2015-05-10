package bomberman;

import bomberman.ecs.component.TestComponent;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class HashMapTest {

    UUID entityId;
    HashMap<UUID, TestComponent> uuidHashMap;

    @Before
    public void setUuidHashMap() {
        entityId = UUID.randomUUID();
        uuidHashMap = new HashMap<>();
    }

    @Test
    public void canNotAddMoreThanOneComponentToEntityID() {
        uuidHashMap.put(entityId, new TestComponent(0));
        uuidHashMap.put(entityId, new TestComponent(1));
        assertTrue(uuidHashMap.values().size() == 1);
    }

    @Test
    public void canOverrideComponentAboutSameTypeToOneKey() {
        uuidHashMap.put(entityId, new TestComponent(0));
        uuidHashMap.put(entityId, new TestComponent(1));

        assertTrue(uuidHashMap.get(entityId).primaryKey == 1);
    }

    @Test
    public void howGetFromEmptyHashMapWorks() {
        assertNull(uuidHashMap.get(entityId));
    }

    @Test
    public void canConvertHashMapToList() {
        uuidHashMap.put(UUID.randomUUID(), new TestComponent(1));
        uuidHashMap.put(UUID.randomUUID(), new TestComponent(2));
        uuidHashMap.put(UUID.randomUUID(), new TestComponent(3));

        List<TestComponent> componentList = new LinkedList<TestComponent>(uuidHashMap.values());

        assertNotNull(componentList);
        assertTrue(componentList.size() == 3);
    }

    @Test
    public void howClearHashMapWorks() {
        uuidHashMap.put(UUID.randomUUID(), new TestComponent(1));

        uuidHashMap.clear();
        assertNotNull(uuidHashMap);
        assertTrue(uuidHashMap.isEmpty());
    }

    @Test
    public void howRemoveFromHashMapWorks() {
        uuidHashMap.put(entityId, new TestComponent(0));
        assertNotNull(uuidHashMap.remove(entityId));
        assertNull(uuidHashMap.remove(entityId));
    }

    @Test
    public void howRemoveFromHashMapWorksWhenKeyDoesNotExist() {
        assertNull(uuidHashMap.remove(entityId));
    }

}
