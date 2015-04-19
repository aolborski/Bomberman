package bomberman.ui;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import static bomberman.ui.UIState.MENU;

/**
 *      Useful to switch between panes.
 */
@Component
public class MenuContext {

    @NotNull
    private ObjectProperty<UIState> uiState;

    public MenuContext() {
        uiState = new SimpleObjectProperty<>(MENU);
    }

    public ObjectProperty<UIState> uiStateProperty() {
        return uiState;
    }
}
