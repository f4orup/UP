package com.example.test2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamesController {

    DBHandler db;

    @FXML
    private ComboBox genresBox;

    @FXML
    private Button LogOutBtn;


    @FXML
    private Button AppBtn;

    @FXML
    private Button MenuBtn;

    @FXML
    private Button DotaBtn;

    @FXML
    private Button CS2Btn;

    @FXML
    private Button RustBtn;

    @FXML
    private Button FortniteBtn;

    @FXML
    private Button WarfaceBtn;

    @FXML
    private Button PubgBtn;

    @FXML
    private Button WOTBtn;

    @FXML
    private Button WOWBtn;

    @FXML
    private Button MinecraftBtn;

    @FXML
    private Button DayZBtn;

    @FXML
    private ImageView dota;
    @FXML
    private ImageView cs2;
    @FXML
    private ImageView rust;
    @FXML
    private ImageView warface;
    @FXML
    private ImageView wot;
    @FXML
    private ImageView wow;
    @FXML
    private ImageView minecraft;
    @FXML
    private ImageView dayz;
    @FXML
    private ImageView pubg;
    @FXML
    private ImageView fortnite;

    List<Button> gamesList = new ArrayList<>();

    List<ImageView> imageList = new ArrayList<>();

    public ObservableList<String> genres = FXCollections.observableArrayList();

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
    void AppBtn(ActionEvent actionEvent) throws SQLException,IOException, ClassNotFoundException{

        AppBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("Application.fxml", "Приложения!", 1100, 700);
    }

    @FXML
    void DotaBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        DotaBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagDota.fxml", "Dota 2!", 1100, 700);
    }

    @FXML
    void CS2Btn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        CS2Btn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagCS2.fxml", "Counter Strike 2!", 1100, 700);
    }

    @FXML
    void DayZBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        DayZBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagDayZ.fxml", "DayZ!", 1100, 700);
    }

    @FXML
    void FortniteBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        FortniteBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagFortnite.fxml", "Fortnite!", 1100, 700);
    }

    @FXML
    void WarfaceBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        WarfaceBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagWarface.fxml", "Warface!", 1100, 700);
    }

    @FXML
    void MinecraftBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        MinecraftBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagMinecraft.fxml", "Minecraft!", 1100, 700);
    }

    @FXML
    void WOTBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        WOTBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagWOT.fxml", "World of Tanks!", 1100, 700);
    }

    @FXML
    void WOWBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        WOWBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagWOW.fxml", "World of Warships!", 1100, 700);
    }

    @FXML
    void PUBGBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        PubgBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagPUBG.fxml", "PUBG!", 1100, 700);
    }

    @FXML
    void RustBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        RustBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ZagRust.fxml", "RUST!", 1100, 700);
    }

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {

        gamesList = Arrays.asList(DotaBtn, CS2Btn, DayZBtn, WarfaceBtn, MinecraftBtn, WOTBtn,
                WOWBtn, PubgBtn, RustBtn, FortniteBtn);

        imageList = Arrays.asList(dota, cs2, dayz, warface, minecraft, wot, wow, pubg,
                rust, fortnite);

        db = new DBHandler();
        try {
            db.getDbConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        genres = db.getGenres();

        genresBox.setItems(genres);

        addComboBoxListener();

    }

    @FXML
    private void filterGamesByGenre(String Genre) {
        for (int i = 0; i<gamesList.size(); i++){
            String gameName = "";
            gameName = gamesList.get(i).getText();
            String genre = "";
            try {
                genre = db.gameInfo(gameName);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            if (!genre.equals(Genre)){
                gamesList.get(i).setVisible(false);
                imageList.get(i).setVisible(false);
            }

            else {
                gamesList.get(i).setVisible(true);
                imageList.get(i).setVisible(true);
            }
        }
    }

    @FXML
    private void addComboBoxListener() {
        genresBox.setOnAction(event -> {
            String selectedGenre = genresBox.getValue().toString();
            if (selectedGenre != null) {
                filterGamesByGenre(selectedGenre);
            }
        });
    }

}
