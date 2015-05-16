package bomberman.ecs.entity;

import bomberman.ecs.component.Position;
import bomberman.ecs.component.RenderComponent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static bomberman.ecs.EntityManager.ENTITY_MANAGER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerActorBuilderTest {

    Entity playerActor;

    @Before
    public void setUp() throws Exception {
        playerActor = new PlayerActorBuilder()
                .position(2, 5)
                .build();
    }

    @After
    public void tearDown() throws Exception {
        playerActor.kill();
    }

    @Test
    public void shouldAddRenderingComponent() {
        assertTrue(ENTITY_MANAGER.containsComponent(playerActor.getId(), RenderComponent.class));
    }

    @Test
    public void hasPropertyPositionComponent() {
        assertEquals(ENTITY_MANAGER.getComponent(playerActor.getId(), Position.class), new
                Position(2,5));
    }
}