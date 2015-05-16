package bomberman.ecs.entity;

import bomberman.ecs.component.Component;
import org.jetbrains.annotations.NotNull;

public interface EntityBuilder {

    @NotNull
    <T extends Component> Entity build();
}
