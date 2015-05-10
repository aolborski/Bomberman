package bomberman.ecs;


import bomberman.ecs.component.Component;
import bomberman.error.DataException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * SINGLETON
 * <p>
 * EntityManager collect all Entity in game. This is like a Data Base Management System.
 */
public class EntityManager {

    public final static EntityManager ENTITY_MANAGER = new EntityManager();

    @NotNull
    private final HashMap<Class, HashMap<UUID, ? extends Component>> componentStores;

    public EntityManager() {
        componentStores = new HashMap<>();
    }

    public void clear() {
        componentStores.keySet().forEach(uuidHashMap -> componentStores.get(uuidHashMap).clear());
        componentStores.clear();
    }

    public <T extends Component> void putComponent(@NotNull final UUID entityID, @NotNull final T
            component) {
        componentStores.putIfAbsent(component.getClass(), new HashMap<>());

        HashMap<UUID, ? extends Component> store = componentStores.get(component.getClass());
        ((HashMap<UUID, T>) store).put(entityID, component);
    }

    public <T extends Component> boolean containsComponent(@NotNull final UUID entityID,
                                                           @NotNull final Class<T> componentType) {
        return componentStores.containsKey(componentType) &&
                (componentStores.get(componentType).containsKey(entityID));
    }

    @Nullable
    public <T extends Component> T getComponent(@NotNull final UUID entityID, @NotNull final
    Class<T> componentType) {
        return(ENTITY_MANAGER.containsComponent(entityID, componentType)) ? (T) componentStores
                .get(componentType).get(entityID) : null;
    }

    @NotNull
    public <T extends Component> List<T> getAllComponentsOfEntity(@NotNull final UUID entityID) {
        List<T> componentsList = new LinkedList<>();
        componentStores.values().forEach(uuidHashMap -> {
            if (uuidHashMap.containsKey(entityID))
                componentsList.add((T) uuidHashMap.get(entityID));
        });

        return componentsList;
    }

    @NotNull
    public <T extends Component> List<T> getAllComponentsOfType(@NotNull final Class<T>
                                                                        componentType) {
        if (!componentStores.containsKey(componentType))
            throw new DataException("ComponentStores doesn't contain this componentType");

        return new LinkedList<T>((Collection<? extends T>) componentStores.get(componentType).values());
    }

    @Nullable
    public <T extends Component> T removeComponent(@NotNull final UUID entityID, @NotNull final
    Class<T> componentType) {
        if (ENTITY_MANAGER.containsComponent(entityID, componentType)) {
            T component = ENTITY_MANAGER.getComponent(entityID, componentType);
            componentStores.get(componentType).remove(entityID);

            if (componentStores.get(componentType).isEmpty())
                componentStores.remove(componentType);

            return component;
        } else
            return null;
    }

    public void removeEntity(@NotNull final UUID entityID) {
        ENTITY_MANAGER.getAllComponentsOfEntity(entityID).forEach(component ->
                ENTITY_MANAGER.removeComponent(entityID, component.getClass()));
    }

    public boolean containsEntity(@Nullable final UUID entityId) {
        List<UUID> entityIdList = new LinkedList<>();
        componentStores.keySet().forEach(componentType ->
                entityIdList.addAll(componentStores.get(componentType).keySet()));
        return entityIdList.contains(entityId);
    }

    /**
     *  size()
     *  replace()
     *  putIfAbsent()
     *  loadFromGameWorld()
     */

    protected boolean isEmpty() {
        return componentStores.isEmpty();
    }

}
