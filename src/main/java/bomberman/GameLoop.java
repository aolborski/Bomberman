package bomberman;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import static javafx.animation.Animation.INDEFINITE;

@Component
public class GameLoop {

    @NotNull
    private final Timeline gameLoopTimeline;

    public GameLoop() {
        gameLoopTimeline = new Timeline();
        gameLoopTimeline.setCycleCount(INDEFINITE);

        gameLoopTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(1000 / 60), event -> {
            //TODO: Updating systems

        }));
    }

    public void start() {
        gameLoopTimeline.play();
    }

    public void stop() {
        gameLoopTimeline.stop();
    }
}
