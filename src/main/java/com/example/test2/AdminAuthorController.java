package com.example.test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminAuthorController {

    DBHandler db = null;
    public int tries = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackBtn;

    @FXML
    private Button GuestBtn;

    @FXML
    private Button CloseBtn;

    @FXML
    private javafx.scene.control.PasswordField PasswordField;

    @FXML
    private TextField LoginField;

    @FXML
    private Button LoginBtn;

    @FXML
    void LoginBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        String Login = LoginField.getText().trim();
        String Password = PasswordField.getText().trim();
        if ((!Login.equals("")) || (!Password.equals(""))) {
            int id = db.checkUs1(Login,Password);
            if (id != -1) {
                UserInfo.setFIO(db.userFIObyID1(id));
                UserInfo.setRole(1);
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AdminMain.fxml"));
                Stage firstage = new Stage();
                Scene scene2 = new Scene(fxmlLoader.load(), 1100, 700);
                firstage.setTitle("Меню администратора!");
                firstage.setResizable(false);
                firstage.setScene(scene2);
                LoginBtn.getScene().getWindow().hide();

                firstage.show();
            } else {
                Alert loginError = new Alert(Alert.AlertType.ERROR);
                loginError.setTitle("ОШИБКА!");
                loginError.setHeaderText("Вы не смогли войти в аккаунт");
                loginError.setContentText("Проверьте правильность логина или пароля!");
                loginError.show();
                tries++;
            }

        }
    }

    @FXML
    void BackBtn(ActionEvent actionEvent) throws SQLException,IOException, ClassNotFoundException{

        BackBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("author.fxml", "Компьютерный клуб!", 1100, 700);
    }

    @FXML
    void CloseBtn(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        Stage stage = (Stage) CloseBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        db = new DBHandler();

    }

}
