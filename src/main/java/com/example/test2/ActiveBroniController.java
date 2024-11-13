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

public class ActiveBroniController {

    @FXML
    private TableColumn<Broni, Integer> ADMINID;

    @FXML
    private Button BackBtn;

    @FXML
    private TableColumn<Broni, Integer> COMPUTERID;

    @FXML
    private TableColumn<Broni, Date> DATE;

    @FXML
    private TableColumn<Broni, Integer> ID;

    @FXML
    private TableView<Broni> BroniTable;

    @FXML
    private TableColumn<Broni, Time> TIME;

    @FXML
    private TableColumn<Broni, Integer> USERID;

    ObservableList<Broni> listM;

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

        ID.setCellValueFactory(new PropertyValueFactory<Broni, Integer>("BroniID"));
        DATE.setCellValueFactory(new PropertyValueFactory<Broni, Date>("Date"));
        TIME.setCellValueFactory(new PropertyValueFactory<Broni, Time>("Time"));
        ADMINID.setCellValueFactory(new PropertyValueFactory<Broni, Integer>("AdminID"));
        USERID.setCellValueFactory(new PropertyValueFactory<Broni, Integer>("UserID"));
        COMPUTERID.setCellValueFactory(new PropertyValueFactory<Broni, Integer>("ComputerID"));

        listM = db.getBroniInfo();
        BroniTable.setItems(listM);
    }

}
