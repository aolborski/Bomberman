package bomberman.ecs.entity;

import bomberman.ecs.component.Component;
import bomberman.ecs.component.Position;
import bomberman.ecs.component.RenderComponent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.LinkedList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 *
 */
public class PlayerActorBuilder implements EntityBuilder {

    private static final Logger LOGGER = getLogger(PlayerActorBuilder.class);

    private List<? extends Component> components = new LinkedList<>();

    public <T extends Component> PlayerActorBuilder position(@NotNull final int x, @NotNull final
    int y) {
        ((List<T>) components).add((T) new Position(x, y));
        return this;
    }

    @NotNull
    @Override
    public <T extends Component> Entity build() {
        ImageView sprite = new ImageView(new Image("bomberman/images/playerActor1.png"));
        sprite.setFitWidth(60.0);
        sprite.setFitHeight(60.0);
        sprite.setPreserveRatio(true);
        sprite.toFront();

        ((List<T>) components).add((T) new RenderComponent(sprite));
        return new Entity(components);
    }
}
