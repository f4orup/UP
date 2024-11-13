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

public class AddSessionController {

    DBHandler db = new DBHandler();

    UserInfo userInfo;

    @FXML
    private TextField date;

    @FXML
    private TextField time;

    @FXML
    private TextField balance;

    @FXML
    private TextField AdminID;

    @FXML
    private TextField UserID;

    @FXML
    private TextField ComputerID;

    @FXML
    private Button addSessionBtn;

    @FXML
    private Button BackBtn;

    @FXML
    void BackBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        BackBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("AdminMain.fxml", "Меню администратора!", 1100, 700);
    }

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException{
        addSessionBtn.setOnAction(event -> {
            try {
                db.addSession(Date.valueOf(date.getText()), Time.valueOf(time.getText()),
                        Integer.parseInt(AdminID.getText()), Integer.parseInt(UserID.getText()), Integer.parseInt(ComputerID.getText()), Integer.parseInt(balance.getText()));
                Alert loginError = new Alert(Alert.AlertType.INFORMATION);
                loginError.setTitle("УСПЕХ!");
                loginError.setHeaderText(null);
                loginError.setContentText("Вы смогли создать сессию!");
                loginError.showAndWait();

                int count = 0;
                count = db.proverkaBroni(Integer.parseInt(UserID.getText()));
                if (count >= 1){
                    db.delFromBroni(Integer.parseInt(UserID.getText()));
                }

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                Alert loginError = new Alert(Alert.AlertType.ERROR);
                loginError.setTitle("ОШИБКА!");
                loginError.setHeaderText("Вы не смогли создать сессию");
                loginError.setContentText("Проверьте свою БД!");
                loginError.showAndWait();
            }
        });
    }
}
