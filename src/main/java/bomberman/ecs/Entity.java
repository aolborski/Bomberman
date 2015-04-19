package bomberman.ecs;

import bomberman.ecs.component.Component;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Abstract class or Base class ?!
 */
public class Entity {

    @NotNull
    private final UUID entityID;

    //TODO: private?
    public Entity() {
        this.entityID = UUID.randomUUID();
        GameWorld.INSTANCE.addEntity(this);
    }

    public Entity(@NotNull final Component... components) {
        this();
        for (Component component : components)
            this.addComponent(component);
    }

    public void addComponent(@NotNull final Component component) {
        GameWorld.INSTANCE.addComponent(this, component);
    }

    public void addComponents(@NotNull final Component... components) {
        for (Component component : components)
            this.addComponent(component);
    }

    @NotNull
    public UUID getEntityID() {
        return entityID;
    }
}