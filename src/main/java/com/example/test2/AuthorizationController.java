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
            System.out.println(id);
                if (id != -1) {
                    System.out.println(id);
                    UserInfo.setFIO(db.userFIObyID(id));
                    System.out.println(UserInfo.getFIO());
                    UserInfo.setRole(0);
                    UserInfo.setUserID(id);
                    System.out.println(UserInfo.getUserID());
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
                    System.out.println("sahd");
                    Stage firstage = new Stage();
                    System.out.println("asd");
                    Scene scene2 = new Scene(fxmlLoader.load(), 1100, 700);
                    System.out.println("zxc");
                    firstage.setTitle("Меню");
                    System.out.println("zxcv");
                    firstage.setResizable(false);
                    System.out.println("jashdu");
                    firstage.setScene(scene2);
                    System.out.println("sahdw");
                    LoginBtn.getScene().getWindow().hide();
                    System.out.println("jashdui");
                    firstage.show();
                    System.out.println("asjh");
                } else {
                    Alert loginError = new Alert(Alert.AlertType.ERROR);
                    loginError.setTitle("ОШИБКА!");
                    loginError.setHeaderText("Вы не смогли войти в аккаунт");
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