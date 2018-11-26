package net.monsterdev.moysklad.ui;

import javafx.stage.Stage;

public interface WindowController extends UIController {
    /**
     * Возвращает сцену, в которой открыто окно, с которомым связан данный контроллер
     * @return
     */
    Stage getStage();
}
