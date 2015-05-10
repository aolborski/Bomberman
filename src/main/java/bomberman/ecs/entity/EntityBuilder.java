package bomberman.ecs.entity;

import org.jetbrains.annotations.NotNull;

public interface EntityBuilder {

    @NotNull
    Entity build();
}
