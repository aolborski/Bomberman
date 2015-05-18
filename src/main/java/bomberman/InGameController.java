package bomberman;

import javafx.fxml.FXML;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class InGameController implements DialogController {
    private FXMLDialog dialog;

    private ScreensConfiguration screens;

    private static final Logger LOGGER = getLogger(InGameController.class);

    @Override
    public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
    }

    @FXML
    public void onBackToMenuClicked() {
        LOGGER.debug("onBackToMenuClicked");

    }
}
