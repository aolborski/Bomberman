package bomberman.ui;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static bomberman.ui.UIState.MENU;

@Component
public class MenuContext {

    private static final Logger LOG = LoggerFactory.getLogger(MenuContext.class);


    @NotNull
    private ObjectProperty<UIState> uiState;

    public MenuContext() {

        LOG.debug("constructor");

        uiState = new SimpleObjectProperty<>(MENU);
    }

    public ObjectProperty<UIState> uiStateProperty() {

        return uiState;
    }
}
