package net.monsterdev.moysklad.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import net.monsterdev.moysklad.Moysklad;
import org.springframework.stereotype.Controller;

@Controller
public class MainController extends AbstractUIController implements WindowController {
    @Override
    public Stage getStage() {
        return Moysklad.primaryStage;
    }

    @FXML
    private void onCustomerOrders(ActionEvent event) {
        //
    }

    @FXML
    private void onInternalOrders(ActionEvent event) {
        //
    }

    @FXML
    private void onProduction(ActionEvent event) {
        //
    }

    @FXML
    private void onInventory(ActionEvent event) {
        //
    }

    @FXML
    private void onGoods(ActionEvent event) {
        //
    }
}
