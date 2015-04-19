package bomberman.ui;


import bomberman.Game;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static bomberman.ui.UIState.MENU;

@Component
public class InGamePaneController implements NodeController {

    @Autowired
    private MenuContext menuContext;

    @FXML
    private Pane inGamePane;

    @FXML
    private Pane gameWorldPane;

    @FXML
    private Button backToMenuButton;

    @FXML
    public void initialize() {
        Game game = new Game();
        game.start();
    }

    @FXML
    public void onBackToMenuClicked() {

        menuContext.uiStateProperty().setValue(MENU);
    }

    @NotNull
    @Override
    public Node getNode() {

        return inGamePane;
    }
}
