package com.example.test2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.*;

public class ActiveSessionsController {
    @FXML
    private TableColumn<Sessions, Integer> ADMINID;

    @FXML
    private TableColumn<Sessions, Integer> BALANCE;

    @FXML
    private Button BackBtn;

    @FXML
    private TableColumn<Sessions, Integer> COMPUTERID;

    @FXML
    private TableColumn<Sessions, Date> DATE;

    @FXML
    private TableColumn<Sessions, Integer> ID;

    @FXML
    private TableView<Sessions> SessionTable;

    @FXML
    private TableColumn<Sessions, Time> TIME;

    @FXML
    private TableColumn<Sessions, Integer> USERID;

    ObservableList<Sessions> listM;

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

        ID.setCellValueFactory(new PropertyValueFactory<Sessions, Integer>("RecordID"));
        DATE.setCellValueFactory(new PropertyValueFactory<Sessions, Date>("Date"));
        TIME.setCellValueFactory(new PropertyValueFactory<Sessions, Time>("Time"));
        ADMINID.setCellValueFactory(new PropertyValueFactory<Sessions, Integer>("AdminID"));
        USERID.setCellValueFactory(new PropertyValueFactory<Sessions, Integer>("UserID"));
        COMPUTERID.setCellValueFactory(new PropertyValueFactory<Sessions, Integer>("ComputerID"));
        BALANCE.setCellValueFactory(new PropertyValueFactory<Sessions, Integer>("Balance"));

        listM = db.getSessionInfo();
        SessionTable.setItems(listM);
    }

}
