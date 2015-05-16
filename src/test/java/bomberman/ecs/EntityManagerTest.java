package bomberman.ecs;

import bomberman.ecs.component.AnotherTestComponent;
import bomberman.ecs.component.Component;
import bomberman.ecs.component.MyTestComponent;
import bomberman.ecs.component.TestComponent;
import bomberman.error.DataException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static bomberman.ecs.EntityManager.ENTITY_MANAGER;
import static org.junit.Assert.*;

public class EntityManagerTest {

    UUID entityID;

    @Before
    public void setEntityID() {
        entityID = UUID.randomUUID();
    }

    @After
    public void clearEntityManager() {
        ENTITY_MANAGER.clear();
    }

    @Test
    public void testClear() {
        ENTITY_MANAGER.putComponent(entityID, new TestComponent(0));
        ENTITY_MANAGER.putComponent(entityID, new AnotherTestComponent());
        ENTITY_MANAGER.putComponent(UUID.randomUUID(), new TestComponent(0));
        ENTITY_MANAGER.clear();

        assertTrue(ENTITY_MANAGER.isEmpty());
    }

    @Test
    public void putComponentTest() {
        ENTITY_MANAGER.putComponent(entityID, new TestComponent(13));
        ENTITY_MANAGER.putComponent(entityID, new TestComponent(7));
        assertEquals(ENTITY_MANAGER.getComponent(entityID, TestComponent.class), new
                TestComponent(7));
    }

    @Test
    public void containsTest() {
        ENTITY_MANAGER.putComponent(entityID, new TestComponent(13));
        assertTrue(ENTITY_MANAGER.containsComponent(entityID, TestComponent.class));
        assertFalse(ENTITY_MANAGER.containsComponent(UUID.randomUUID(), TestComponent.class));
    }

    @Test
    public void getComponentTest() {
        ENTITY_MANAGER.putComponent(entityID, new TestComponent(13));
        assertTrue(ENTITY_MANAGER.getComponent(entityID, TestComponent.class).primaryKey == 13);
        assertNull(ENTITY_MANAGER.getComponent(UUID.randomUUID(), TestComponent.class));
    }

    @Test
    public void entityIDCanNotHasSameComponentType() {
        ENTITY_MANAGER.putComponent(entityID, new TestComponent(13));
        ENTITY_MANAGER.putComponent(entityID, new TestComponent(7));
        assertTrue(ENTITY_MANAGER.getAllComponentsOfEntity(entityID).size() == 1);
    }

    @Test
    public void getAllComponentsOfEntityTest() {
        ENTITY_MANAGER.putComponent(entityID, new TestComponent(7));
        ENTITY_MANAGER.putComponent(entityID, new AnotherTestComponent());
        assertTrue(ENTITY_MANAGER.getAllComponentsOfEntity(entityID).size() == 2);
    }

    @Test
    public void getAllComponentsOfTypeTest() {
        ENTITY_MANAGER.putComponent(UUID.randomUUID(), new TestComponent(6));
        ENTITY_MANAGER.putComponent(UUID.randomUUID(), new TestComponent(10));
        ENTITY_MANAGER.putComponent(UUID.randomUUID(), new TestComponent(14));
        ENTITY_MANAGER.putComponent(UUID.randomUUID(), new AnotherTestComponent());
        assertNotNull(ENTITY_MANAGER.getAllComponentsOfType(TestComponent.class));
        assertTrue(ENTITY_MANAGER.getAllComponentsOfType(TestComponent.class).size() == 3);
        assertTrue(ENTITY_MANAGER.getAllComponentsOfType(AnotherTestComponent.class).size() == 1);
    }

    @Test(expected = DataException.class)
    public void getAllComponentsOfTypeThrowWhenComponentTypeDoesNotExist() {
        ENTITY_MANAGER.getAllComponentsOfType(TestComponent.class);
    }

    @Test
    public void removeComponentTest() {
        TestComponent testComponent = new TestComponent(13);
        ENTITY_MANAGER.putComponent(entityID, testComponent);

        Component component = ENTITY_MANAGER.removeComponent(entityID, TestComponent.class);

        assertNotNull(component);
        assertTrue(component.equals(testComponent));
        assertNull(ENTITY_MANAGER.removeComponent(entityID, TestComponent.class));
        assertTrue(ENTITY_MANAGER.isEmpty());
    }

    @Test
    public void removeEntityTest() {
        ENTITY_MANAGER.putComponent(entityID, new TestComponent(13));
        ENTITY_MANAGER.putComponent(entityID, new AnotherTestComponent());

        UUID entityIDTemp = UUID.randomUUID();
        ENTITY_MANAGER.putComponent(entityIDTemp, new TestComponent(7));

        ENTITY_MANAGER.removeEntity(entityID);
        assertFalse(ENTITY_MANAGER.containsComponent(entityID, TestComponent.class));
        assertFalse(ENTITY_MANAGER.containsComponent(entityID, AnotherTestComponent.class));
        assertTrue(ENTITY_MANAGER.containsComponent(entityIDTemp, TestComponent.class));
    }

    @Test
    public void containsEntityIdTest() {
        ENTITY_MANAGER.putComponent(entityID, new TestComponent(13));
        ENTITY_MANAGER.putComponent(entityID, new AnotherTestComponent());

        assertTrue(ENTITY_MANAGER.containsEntity(entityID));
        assertFalse(ENTITY_MANAGER.containsEntity(UUID.randomUUID()));
    }

    @Test
    public void getAllEntietiesPossesingComponents() {
        UUID entityID_2 = UUID.randomUUID();
        UUID entityID_3 = UUID.randomUUID();

        ENTITY_MANAGER.putComponent(entityID, new TestComponent(13));
        ENTITY_MANAGER.putComponent(entityID, new AnotherTestComponent());
        ENTITY_MANAGER.putComponent(entityID, new MyTestComponent());
        ENTITY_MANAGER.putComponent(entityID_2, new TestComponent(13));
        ENTITY_MANAGER.putComponent(entityID_2, new AnotherTestComponent());
        ENTITY_MANAGER.putComponent(entityID_3, new TestComponent(13));

        assertTrue(ENTITY_MANAGER.getAllEntitiesPossessingComponent(TestComponent.class).size() == 3);
        assertTrue(ENTITY_MANAGER.getAllEntitiesPossessingComponent(AnotherTestComponent.class).size() == 2);
        assertTrue(ENTITY_MANAGER.getAllEntitiesPossessingComponent(MyTestComponent.class).size() == 1);
    }

}