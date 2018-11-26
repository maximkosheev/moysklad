package net.monsterdev.moysklad.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import net.monsterdev.moysklad.Moysklad;
import net.monsterdev.moysklad.services.MoyskladService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class LoginController extends AbstractUIController implements WindowController {

    @Autowired
    private MoyskladService moyskladService;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        getStage().setTitle(Moysklad.APPLICATION_NAME + " - Вход");
    }

    @Override
    public Stage getStage() {
        return UIController.primaryStage();
    }

    @FXML
    private void onConnect(ActionEvent event) {
        moyskladService.connect("admin@altimuz", "123123");
    }
}
