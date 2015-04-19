package bomberman.ecs.component;

import org.jetbrains.annotations.NotNull;

import static bomberman.ecs.component.ComponentType.POSITION;

public class Position implements Component {

    @NotNull
    public Integer x;

    @NotNull
    public Integer y;

    public Position(@NotNull final Integer x, @NotNull final Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public ComponentType getComponentType() {
        return POSITION;
    }
}
