package bomberman;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static javafx.scene.input.KeyCombination.NO_MATCH;
import static javafx.stage.StageStyle.UNDECORATED;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("bomberman/meta-info/bomberman-spring-context.xml");
        BmFxmlLoader loader = appContext.getBean(BmFxmlLoader.class);
        Parent root = loader.load();
        primaryStage.setTitle("Bomberman");
        primaryStage.initStyle(UNDECORATED);
        primaryStage.centerOnScreen();

        Scene scene = new Scene(root, 800.0, 600.0);

        scene.getStylesheets().add("bomberman/ui/skins/bomberman-new.css");
        primaryStage.setFullScreenExitKeyCombination(NO_MATCH);
        primaryStage.setFullScreen(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
