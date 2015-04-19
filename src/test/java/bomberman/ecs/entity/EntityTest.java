package bomberman.ecs.entity;

import bomberman.ecs.Entity;
import bomberman.ecs.GameWorld;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

public class EntityTest {

    Entity entity;

    @Before
    public void setEntity() {
        entity = new Entity();
    }

    /**
     * Jak sprawdzic czy istnieje bez robienia getera na liste? Chce sprawdzic czy lista ma jeden
     * element bez wyciagania jej.
     */
    @Test
    public void doesEntityIsInGameWorld() {
        assertTrue(GameWorld.INSTANCE.isEntityExist(entity.getEntityID()));



    }

    @Test
    public void doesEntityHasTheirID() {
        assertTrue(GameWorld.INSTANCE.isEntityExist(entity.getEntityID()));
    }

}