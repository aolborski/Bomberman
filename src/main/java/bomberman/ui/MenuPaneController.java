package bomberman.ui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static bomberman.ui.UIState.*;


@Component
public class MenuPaneController implements NodeController {

    @Autowired
    private MenuContext menuContext;

    @FXML
    private BorderPane menuPane;

    @FXML
    private Button startGameButton;

    @FXML
    private Button exitButton;

    @FXML
    public void onStartGameButtonClicked() {

        menuContext.uiStateProperty().setValue(IN_GAME);
    }

    @FXML
    public void onExitButtonClicked() {

        System.exit(0);
    }

    @NotNull
    @Override
    public Node getNode() {

        return menuPane;
    }
}
