package com.example.test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegController {

    DBHandler db = new DBHandler();

    @FXML
    private Button BackBtn;

    @FXML
    private TextField FIO;

    @FXML
    private TextField passport;

    @FXML
    private TextField login;

    @FXML
    private TextField passw;

    @FXML
    private Button addBtn;


    @FXML
    void BackBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        BackBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("AdminMain.fxml", "Меню администратора!", 1100, 700);
    }


    @FXML
    private void initialize() throws SQLException, ClassNotFoundException{

        addBtn.setOnAction(event -> {
            try {
                db.userReg(FIO.getText(), passport.getText(), login.getText(), passw.getText());
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            addBtn.getScene().getWindow().hide();
            SceneChanger.changeScene("AdminMain.fxml", "Меню администратора!", 1100, 700);
        });
    }

}
