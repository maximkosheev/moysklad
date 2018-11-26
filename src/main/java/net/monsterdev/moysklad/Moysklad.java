package net.monsterdev.moysklad;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.monsterdev.moysklad.ui.LoginController;
import net.monsterdev.moysklad.utils.SpringFXMLLoader;

import java.net.URL;

public class Moysklad extends Application {
    public static String APPLICATION_NAME = "Moysklad";
    public static Stage primaryStage = null;
    private static Moysklad instance = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Moysklad.primaryStage = primaryStage;
        Moysklad.instance = this;
        LoginController controller = (LoginController) SpringFXMLLoader.load("/net/monsterdev/moysklad/ui/login.fxml");
        Moysklad.primaryStage.setScene(new Scene((Parent) controller.getView(), 600, 400));
        Moysklad.primaryStage.show();
        Moysklad.primaryStage.setOnCloseRequest(event -> {
            //
        });
    }

    public static URL getResource(String name) {
        return instance.getClass().getResource(name);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
