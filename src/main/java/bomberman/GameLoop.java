package bomberman;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import static bomberman.Constants.DEBUG_FAST_FPS;
import static bomberman.ecs.EntityManager.ENTITY_MANAGER;
import static javafx.animation.Animation.INDEFINITE;


public class GameLoop {
    private final Timeline gameLoopTimeline;

    public GameLoop() {
        gameLoopTimeline = new Timeline();
        gameLoopTimeline.setCycleCount(INDEFINITE);

        gameLoopTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(DEBUG_FAST_FPS), event -> {
            //TODO: Updating systems
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
