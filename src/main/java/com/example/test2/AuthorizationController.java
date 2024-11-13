package com.example.test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AuthorizationController {
    DBHandler db = null;
    public int tries = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField LoginField;

    @FXML
    private Button LoginBtn;

    @FXML
    private Button AdminBtn;

    @FXML
    private Button CloseBtn;



    @FXML
    void LoginBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        String Login = LoginField.getText().trim();
        String Password = PasswordField.getText().trim();
        if ((!Login.isEmpty()) || (!Password.isEmpty())) {
                int id = db.checkUs(Login,Password);
                if (id != -1) {
                    UserInfo.setFIO(db.userFIObyID(id));
                    UserInfo.setRole(0);
                    UserInfo.setUserID(id);
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
                    Stage firstage = new Stage();
                    Scene scene2 = new Scene(fxmlLoader.load(), 1100, 700);
                    firstage.setTitle("Меню");
                    firstage.setResizable(false);
                    firstage.setScene(scene2);
                    LoginBtn.getScene().getWindow().hide();
                    firstage.show();
                } else {
                    Alert loginError = new Alert(Alert.AlertType.ERROR);
                    loginError.setTitle("ОШИБКА!");
                    loginError.setHeaderText("Вы не можете зайти в аккаунт без баланса");
                    loginError.setContentText("Проверьте правильность логина или пароля!");
                    loginError.show();
                    tries++;
                }

        } else {
            System.out.println("ОШИБКА");
        }
    }

    @FXML
    void CloseBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        Stage stage = (Stage) CloseBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void AdminBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        AdminBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("AdminAuthor.fxml", "Авторизация администратора!", 1100, 700);
    }

    @FXML
    void initialize() {
        db = new DBHandler();
        LoginField.setStyle("-fx-prompt-text-fill: black;");
        PasswordField.setStyle("-fx-prompt-text-fill: black;");
    }


}