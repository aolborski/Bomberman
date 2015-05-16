package bomberman.ecs.entity;

import bomberman.ecs.component.AnotherTestComponent;
import bomberman.ecs.component.MyTestComponent;
import bomberman.ecs.component.TestComponent;
import bomberman.ecs.component.Component;
import bomberman.error.EntityHasNotAnyComponent;
import bomberman.error.EntityWasKilled;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static bomberman.ecs.EntityManager.ENTITY_MANAGER;
import static org.junit.Assert.*;

public class EntityTest {

    Entity entity;
    UUID entityId;
    List<? extends Component> componentList;

    @Before
    public <T extends Component> void setUp() throws Exception {
        componentList = new LinkedList<>();
        ((LinkedList<T>) componentList).add((T) new TestComponent(13));
        entity = new Entity(componentList);
        entityId = entity.getId();
    }

    @After
    public void tearDown() throws Exception {
        entity.kill();
    }

    @Test
    public void entityConstructorTest() {
        assertTrue(ENTITY_MANAGER.containsComponent(entity.getId(), TestComponent.class));
        assertFalse(ENTITY_MANAGER.containsComponent(entity.getId(), AnotherTestComponent.class));
    }

    @Test(expected = EntityHasNotAnyComponent.class)
    public void entityConstructorThrowWhenComponentListIsEmpty() {
        List<? extends Component> componentListTmp = new LinkedList<>();
        new Entity(componentListTmp);
    }

    @Test
    public void killEntityTest() {
        entity.kill();
        Entity entityTmp = new Entity(componentList);
        assertFalse(ENTITY_MANAGER.containsEntity(entity.getId()));
        assertTrue(ENTITY_MANAGER.containsEntity(entityTmp.getId()));
    }

    //TODO: For now i don't have idea how pass this test
//    @Test(expected = EntityWasKilled.class)
//    public void killEntityThrowWhenUseMethodsAfterKilled() {
//        entity.kill();
//        entity.addComponent(new AnotherTestComponent());
//    }

    @Test
    public void addComponentTest() {
        entity.addComponent(new AnotherTestComponent());
        assertTrue(ENTITY_MANAGER.containsComponent(entity.getId(), AnotherTestComponent.class));
        assertFalse(ENTITY_MANAGER.containsComponent(entity.getId(), MyTestComponent.class));
    }

    @Test
    public void removeComponentInfluenceToEntityManagerTest() {
        entity.addComponent(new TestComponent(13));
        entity.addComponent(new AnotherTestComponent());
        entity.removeComponent(AnotherTestComponent.class);
        assertTrue(ENTITY_MANAGER.containsComponent(entity.getId(), TestComponent.class));
        assertFalse(ENTITY_MANAGER.containsComponent(entity.getId(), AnotherTestComponent.class));
    }

    @Test
    public <T extends Component> void removeComponentReturnValueTest() {
        entity.addComponent(new TestComponent(13));
        entity.addComponent(new AnotherTestComponent());
        T component = entity.removeComponent(TestComponent.class);
        assertEquals(component, new TestComponent(13));
        assertNotEquals(component, new TestComponent(7));
        assertNull(entity.removeComponent(TestComponent.class));
        assertNotNull(entity.removeComponent(AnotherTestComponent.class));
    }
}