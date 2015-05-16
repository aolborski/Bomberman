package bomberman;

import bomberman.ecs.entity.CrateBuilder;
import bomberman.ecs.entity.Entity;
import bomberman.ecs.entity.PlayerActorBuilder;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import static bomberman.ecs.EntityManager.ENTITY_MANAGER;
import static javafx.animation.Animation.INDEFINITE;

@Component
public class GameLoop {

    @NotNull
    private final Timeline gameLoopTimeline;

    public GameLoop() {
        gameLoopTimeline = new Timeline();
        gameLoopTimeline.setCycleCount(INDEFINITE);

        Entity playerActor = new PlayerActorBuilder()
                .position(5, 5)
                .build();

        Entity crate1 = new CrateBuilder()
                .position(7, 7)
                .build();

        Entity crate2 = new CrateBuilder()
                .position(100, 100)
                .build();

        //TODO: renderSystem is null here, that is why throw
//        renderSystem.initialize();

        gameLoopTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(1000 / 60), event -> {
            //TODO: Updating systems

//            renderSystem.update();

        }));
    }


    public void start() {

        gameLoopTimeline.play();
    }

    public void stop() {
        ENTITY_MANAGER.clear();
        gameLoopTimeline.stop();
    }
}
