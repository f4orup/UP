package com.example.test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public class AddBroniController {
    DBHandler db = new DBHandler();

    @FXML
    private TextField date;

    @FXML
    private TextField time;

    @FXML
    private TextField AdminID;

    @FXML
    private TextField UserID;

    @FXML
    private TextField ComputerID;

    @FXML
    private Button addBroniBtn;

    @FXML
    private Button BackBtn;

    @FXML
    void BackBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        BackBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("AdminMain.fxml", "Меню администратора!", 1100, 700);
    }

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException{
        addBroniBtn.setOnAction(event -> {
            try {
                db.addBroni(Date.valueOf(date.getText()), Time.valueOf(time.getText()),
                        Integer.parseInt(AdminID.getText()), Integer.parseInt(UserID.getText()), Integer.parseInt(ComputerID.getText()));
                Alert loginError = new Alert(Alert.AlertType.INFORMATION);
                loginError.setTitle("УСПЕХ!");
                loginError.setHeaderText(null);
                loginError.setContentText("Вы смогли создать бронь!");
                loginError.showAndWait();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                Alert loginError = new Alert(Alert.AlertType.ERROR);
                loginError.setTitle("ОШИБКА!");
                loginError.setHeaderText("Вы не смогли создать бронь");
                loginError.setContentText("Проверьте свою БД!");
                loginError.showAndWait();
            }
        });
    }

}
