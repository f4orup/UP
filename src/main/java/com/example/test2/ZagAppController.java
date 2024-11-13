package com.example.test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.SQLException;

public class ZagAppController {

    @FXML
    private Button LogOutBtn;

    @FXML
    void LogOutBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        LogOutBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("Application.fxml", "Приложения!", 1100, 700);
    }

}
