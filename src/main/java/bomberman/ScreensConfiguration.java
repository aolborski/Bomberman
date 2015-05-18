package bomberman;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@Lazy
public class ScreensConfiguration {
    private Stage primaryStage;

    //TODO: Should i get @NotNull final?
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showScreen(Parent screen) {
        primaryStage.setScene(new Scene(screen, 1280, 800));
        primaryStage.show();
    }

    @Bean
    @Scope("prototype")
    FXMLDialog mainMenuDialog() {
        return new FXMLDialog(mainMenuController(), getClass().getResource("MainMenuPaneOLD" +
                ".fxml"), primaryStage, StageStyle.UNDECORATED);
    }

    @Bean
    @Scope("prototype")
    MainMenuController mainMenuController() {
        return new MainMenuController();
    }

    @Bean
    @Scope("prototype")
    FXMLDialog inGameDialog() {
        return new FXMLDialog(inGameController(), getClass().getResource("InGamePane.fxml"), primaryStage, StageStyle.UNDECORATED);
    }

    @Bean
    @Scope("prototype")
    InGameController inGameController() {
        return new InGameController();
    }




}
