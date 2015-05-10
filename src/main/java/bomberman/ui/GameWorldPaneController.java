package bomberman.ui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Iterator;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class GameWorldPaneController implements Iterable<Node> {

    private static final Logger LOGGER = getLogger(GameWorldPaneController.class);

    @FXML
    private Pane gameWorldPane;

    @FXML
    public void initialize() {
        gameWorldPane.setOnMouseClicked(event -> {
            LOGGER.debug("gameWorldPane clicked");
        });
    }

    public Pane getGameWorldPane() {
        return gameWorldPane;
    }

    @Override
    public Iterator<Node> iterator() {
        return gameWorldPane.getChildren().iterator();
    }
}
