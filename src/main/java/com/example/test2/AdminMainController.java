package com.example.test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;

public class AdminMainController {

    @FXML
    private Button LogOutBtn;

    @FXML
    private Button ProductBtn;

    @FXML
    private Button addSessionBtn;

    @FXML
    private Button ActiveSession;

    @FXML
    private Button ActiveBroni;

    @FXML
    private Button activeUsers;

    @FXML
    private Button broniBtn;

    @FXML
    private Button RegBtn;

    @FXML
    private Label fioLabel;

    @FXML
    void LogOutBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        LogOutBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("AdminAuthor.fxml", "Авторизация администратора!", 1100, 700);
    }

    @FXML
    void broniBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        broniBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("AddBroni.fxml", "Создание брони", 1100, 700);
    }

    @FXML
    void ProductBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        ProductBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("Products.fxml", "Магазин!", 1100, 700);
    }

    @FXML
    void RegBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        RegBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("UserReg.fxml", "Регистрация пользователя!", 1100, 700);
    }

    @FXML
    void addSessionBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        addSessionBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("AddSession.fxml", "Создание сессии!", 1100, 700);
    }

    @FXML
    void activeUsers(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        activeUsers.getScene().getWindow().hide();
        SceneChanger.changeScene("ActiveUser.fxml", "Зарегистрированные пользователи!", 1100, 700);
    }

    @FXML
    void ActiveSession(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        ActiveSession.getScene().getWindow().hide();
        SceneChanger.changeScene("ActiveSessions.fxml", "Активные сессии!", 1100, 700);
    }

    @FXML
    void ActiveBroni(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        ActiveBroni.getScene().getWindow().hide();
        SceneChanger.changeScene("ActiveBroni.fxml", "Активные брони!", 1100, 700);
    }

    @FXML
    void initialize() {
        fioLabel.setText(UserInfo.getFIO());
    }

}
