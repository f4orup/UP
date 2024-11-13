package com.example.test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.SQLException;

public class ApplicationController {


    @FXML
    private Button LogOutBtn;

    @FXML
    private Button MenuBtn;

    @FXML
    private Button GameBtn;

    @FXML
    private Button YandexBtn;

    @FXML
    private Button TSBtn;

    @FXML
    private Button DiscordBtn;

    @FXML
    private Button SteamBtn;

    @FXML
    void LogOutBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        LogOutBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("author.fxml", "Компьютерный клуб!", 1100, 700);
    }

    @FXML
    void MenuBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        LogOutBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("Main.fxml", "Меню!", 1100, 700);
    }

    @FXML
    void GameBtn(ActionEvent actionEvent) throws SQLException,IOException, ClassNotFoundException{

        GameBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("Games.fxml", "Игры!", 1100, 700);
    }

    @FXML
    void YandexBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        YandexBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagYandex.fxml", "Yandex!", 1100, 700);
    }

    @FXML
    void TSBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        TSBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagTS.fxml", "Team Speak!", 1100, 700);
    }

    @FXML
    void DiscordBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        DiscordBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagDiscord.fxml", "Discord!", 1100, 700);
    }

    @FXML
    void SteamBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        SteamBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagSteam.fxml", "Steam!", 1100, 700);
    }

}
