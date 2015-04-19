package bomberman.ecs.component;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import org.jetbrains.annotations.NotNull;

import static bomberman.ecs.component.ComponentType.*;

public class Sprite implements Component {

    @NotNull
    public final Shape shape;

    @NotNull
    public javafx.scene.paint.Color color;

    public Sprite(final @NotNull Shape shape, final @NotNull Color color) {
        this.shape = shape;
        this.color = color;


    }

    @Override
    public ComponentType getComponentType() {
        return SPRITE;
    }
}
