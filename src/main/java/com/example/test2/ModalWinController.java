package com.example.test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ModalWinController {

    DBHandler db = new DBHandler();

    UserInfo userInfo;

    @FXML
    private Button LogOutBtn;

    @FXML
    private Button notLogOut;

    @FXML
    void LogOutBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        db.getDbConnection();

        LogOutBtn.getScene().getWindow().hide();

        db.delFromRecord(userInfo.getUserID());

        SceneChanger.changeScene("author.fxml", "Авторизация!", 1100, 700);
    }

    @FXML
    void notLogOut(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        LogOutBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("Main.fxml", "Меню!", 1100, 700);
    }


}
