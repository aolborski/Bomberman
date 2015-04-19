package bomberman.ecs.entity;

import bomberman.ecs.Entity;
import bomberman.ecs.component.Component;
import bomberman.ecs.component.Position;
import bomberman.ecs.component.Rendering;
import bomberman.ecs.component.Sprite;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static bomberman.ecs.component.ComponentType.POSITION;
import static bomberman.ecs.component.ComponentType.RENDERING;
import static bomberman.ecs.component.ComponentType.SPRITE;
import static javafx.scene.paint.Color.*;

/**
 * Co chce miec? Bede chcial napisac w programie:
 *      "Crate skrzynia1 = new Crate(new Position(10,10), new Rendering());"
 *
 * Dosc logiczne wydaje sie zalozenie zeby istniejacy byt musial miec chociaz jeden komponent
 * opisujacy ten byt. Ciekawe jak to wyegzekwowac?
 */
public class Crate extends Entity {

    private static final Logger LOGGER = LoggerFactory.getLogger(Crate.class);

    public Crate(Position position) {
        LOGGER.debug("Crate constructor");
        List<Component> componentList = new ArrayList<>();

        componentList.add(position);
        componentList.add(new Rendering());
        componentList.add(new Sprite(new Rectangle(50.0, 50.0), GREENYELLOW));
        Component[] components = componentList.toArray(new Component[componentList.size()]);

//        new Crate(components);

        new Entity(components);
    }

    private Crate(@NotNull Component... components) {
        super(components);
    }
}
