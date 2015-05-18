package bomberman;

import javafx.fxml.FXML;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import static org.slf4j.LoggerFactory.getLogger;

public class MainMenuController implements DialogController{
    private FXMLDialog dialog;

    private ScreensConfiguration screensConfiguration;


    private static final Logger LOGGER = getLogger(MainMenuController.class);


    @Override
    public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
    }

    @FXML
    public void onStartGameButtonClicked() {
        LOGGER.debug("onStartGameButtonClicked");

        screensConfiguration.inGameDialog().show();

    }

    @FXML
    public void onExitButtonClicked() {
        LOGGER.debug("clicked cancel");
        dialog.close();
    }


}
