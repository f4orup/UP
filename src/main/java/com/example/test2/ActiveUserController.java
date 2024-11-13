package com.example.test2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActiveUserController {

    @FXML
    private TableView<Users> tableUser;

    @FXML
    private TableColumn<Users, Integer> ID;

    @FXML
    private TableColumn<Users, String> FIO;

    @FXML
    private TableColumn<Users, String> Login;

    @FXML
    private TableColumn<Users, String> Passport;

    @FXML
    private Button BackBtn;

    ObservableList<Users> listM;

    int index = -1;

    DBHandler db = new DBHandler();

    ResultSet rs = null;

    PreparedStatement prst = null;

    @FXML
    void BackBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{

        BackBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("AdminMain.fxml", "Меню администратора!", 1100, 700);
    }

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException{

        ID.setCellValueFactory(new PropertyValueFactory<Users, Integer>("UserID"));
        FIO.setCellValueFactory(new PropertyValueFactory<Users, String>("FIO"));
        Passport.setCellValueFactory(new PropertyValueFactory<Users, String>("Passport"));
        Login.setCellValueFactory(new PropertyValueFactory<Users, String>("Login"));

        listM = db.getUsersInfo();
        tableUser.setItems(listM);
    }

}
