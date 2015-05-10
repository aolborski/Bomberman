package bomberman.ui;

//import bomberman.ui.MenuContext;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static bomberman.ui.UIState.*;

/**
 * is responsible for swapping panes
 */
@Component
public class RootPaneController {

    private static final Logger LOG = LoggerFactory.getLogger(RootPaneController.class);

    @Autowired
    private MenuPaneController menuPaneController;

    @Autowired
    private InGamePaneController inGamePaneContoller;

    @Autowired
    private MenuContext menuContext;

    /**
     * initializes menuContext and sets listener for swapping panes
     */
    @PostConstruct
    public void init() {

        menuContext.uiStateProperty().addListener((observable, oldValue, newValue) -> {
            NodeController currentStateController = stateController(oldValue);
            NodeController newStateController = stateController(newValue);

            currentStateController.getNode().setVisible(false);
            newStateController.getNode().setVisible(true);
        });
    }

    @NotNull
    private NodeController stateController(UIState uiState) {
        return uiState == MENU ? menuPaneController : inGamePaneContoller;
    }

}
