package bomberman.ecs.entity;

import bomberman.ecs.component.Component;
import bomberman.error.EntityHasNotAnyComponent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

import static bomberman.ecs.EntityManager.ENTITY_MANAGER;

//TODO: Czy przekazywanie komponentow w liscie jest ok?

//TODO: A moze po prostu dac pole bedace kolekcja komponentow tego bytu?
/**
 * Powyzsza propozycja rozwiazania jest ideowo zblizona do implementacji grafu w ktorej kazdy
 * wierzcholek posiada liste incydentnych ze soba wierzcholkow.
 */

//TODO: Czy jak dam w konstruktorze pusta lista to w ogole doda sie entity do ENTITY_MANAGER?
/**
 * Przetestujmy to :D !
 */

//TODO: Czy moze byc byt ktory ma pusty zbior componentow?
/**
 *  Tak szczerze to nie wiem. To pewnie w praniu wyjdzie.
 *
 *  Chociaz mysle, ze taka sytuacja powinna w ogole rzucac wyjatek i na razie tak zrobie -
 *  najwyzej pozniej to zmienie.
 */

//TODO: Czy po zabiciu bytu powinny byc dostepne wykonywanie operacji na nim?
/**
 * Mysle ze nie. Stawiam ze powinien byc wtedy rzucany wyjatek.
 */
public class Entity {

    private final UUID entityId;

    public Entity(@NotNull final List<? extends Component> componentList) {
        if (componentList.isEmpty())
            throw new EntityHasNotAnyComponent("Entity.Constructor");

        entityId = UUID.randomUUID();
        componentList.forEach(component -> ENTITY_MANAGER.putComponent(entityId, component));
    }

    public UUID getId() {
        return entityId;
    }

    public void kill() {
        ENTITY_MANAGER.removeEntity(entityId);
    }

    public <T extends Component> void addComponent(@NotNull final T component) {
        ENTITY_MANAGER.putComponent(entityId, component);
    }
}
