package bomberman.ecs.entity;

import bomberman.ecs.Entity;
import bomberman.ecs.GameWorld;
import bomberman.ecs.component.Component;
import bomberman.ecs.component.Position;
import bomberman.ecs.component.Rendering;
import bomberman.ecs.component.Sprite;
import javafx.scene.shape.Circle;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.paint.Color.BLUE;

public class Player extends Entity {

    private static final Logger LOGGER = LoggerFactory.getLogger(Player.class);

    public Player(Position position) {

        LOGGER.debug("Player constructor");
        List<Component> componentList = new ArrayList<>();

        componentList.add(position);
        componentList.add(new Rendering());
        componentList.add(new Sprite(new Circle(50), BLUE));

        Component[] components = componentList.toArray(new Component[componentList.size()]);

        //TODO: poprawic
        new Entity(components);
    }
}
