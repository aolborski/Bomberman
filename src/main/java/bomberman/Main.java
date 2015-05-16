package bomberman;

import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static javafx.scene.input.KeyCombination.NO_MATCH;
import static javafx.stage.StageStyle.UNDECORATED;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("bomberman/meta-info/bomberman-spring-context.xml");
        FxmlLoader loader = appContext.getBean(FxmlLoader.class);
        Parent root = loader.load();

        stage.setTitle("Bomberman");
        stage.initStyle(UNDECORATED);
        stage.centerOnScreen();

        Scene scene = new Scene(root, 1280, 800);
        scene.getStylesheets().add("bomberman/ui/skins/bomberman-new.css");
        scene.setCursor(new ImageCursor(new Image("bomberman/images/bombermanCursor.png")));

        stage.setFullScreenExitKeyCombination(NO_MATCH);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }
}
