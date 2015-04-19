package bomberman.ecs;


import bomberman.ecs.component.Component;
import bomberman.ecs.component.ComponentType;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * SINGLETON
 */
public class GameWorld {

    public final static GameWorld INSTANCE = new GameWorld();

    @NotNull
    private final List<UUID> entitiesIDList;

    @NotNull
    private final Map<ComponentType, HashMap<UUID, ? extends Component>> componentStore;

    public GameWorld() {
        entitiesIDList = new ArrayList<>();
        componentStore = new HashMap<>();

        for (ComponentType componentType : ComponentType.values())
            componentStore.put(componentType, new HashMap<>());
    }

    public <T extends Component> void addComponent(@NotNull final Entity entity, @NotNull final T
            component) {

        HashMap<UUID, ? extends Component> storeOfComponentType = componentStore.get(component
                .getComponentType());

        ((HashMap<UUID, T>) storeOfComponentType).put(entity.getEntityID(), component);
    }

    public void addEntity(@NotNull final Entity entity) {
        entitiesIDList.add(entity.getEntityID());
    }

    @NotNull
    public <T extends Component> T getComponent(@NotNull final UUID entityID, @NotNull final
    ComponentType componentType) {
        return (T) componentStore.get(componentType).get(entityID);
    }

    public boolean isEntityExist(@NotNull final UUID entityID) {
        return entitiesIDList.contains(entityID);
    }
}
