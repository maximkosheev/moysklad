package net.monsterdev.moysklad.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import net.monsterdev.automosreg.config.AppConfig;
import net.monsterdev.moysklad.ui.UIController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class SpringFXMLLoader {
    private static Logger LOG = LogManager.getLogger(SpringFXMLLoader.class);
    private static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AppConfig.class);

    public static UIController load(String url) throws IOException {
        try (InputStream fxmlStream = SpringFXMLLoader.class.getResourceAsStream(url)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(APPLICATION_CONTEXT::getBean);
            Node view = (Node) loader.load(fxmlStream);
            UIController controller = loader.getController();
            controller.setView(view);
            return controller;
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("Can't load FXML resource with error: " + e.getMessage());
            throw e;
        }
    }
}
