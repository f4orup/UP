package com.example.test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class MainController {
    public int sum = 0;
    public int chislo = 0;
    DBHandler db = new DBHandler();

    UserInfo userInfo;

    private static int balance;

    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    @FXML
    private Button MenuBtn;

    @FXML
    private Button AppBtn;

    @FXML
    private Button GameBtn;

    @FXML
    private Button CompBtn;

    @FXML
    private Button LogOutBtn;

    @FXML
    private Button BuyTime;

    @FXML
    private Label fioLabel;

    @FXML
    private Label balanceLabel;

    @FXML
    private Label timeLabel;

    public static int getBalance() {
        return balance;
    }

    public static void setBalance(int balance) {
        MainController.balance = balance;
    }


    @FXML
    void LogOutBtn(ActionEvent actionEvent) throws SQLException,IOException, ClassNotFoundException{

        LogOutBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("ModalWin.fxml", "Выход!", 400, 200);
    }

    @FXML
    void GameBtn(ActionEvent actionEvent) throws SQLException,IOException, ClassNotFoundException{

        GameBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("Games.fxml", "Игры!", 1100, 700);
    }

    @FXML
    void AppBtn(ActionEvent actionEvent) throws SQLException,IOException, ClassNotFoundException{

        AppBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("Application.fxml", "Приложения!", 1100, 700);
    }

    @FXML
    void CompBtn(ActionEvent actionEvent) throws SQLException,IOException, ClassNotFoundException{

        CompBtn.getScene().getWindow().hide();
        SceneChanger.changeScene("Computers.fxml", "Наши компьютеры!", 1100, 700);
    }

    @FXML
    void BuyTime(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException{
        AtomicInteger tarif = new AtomicInteger(120);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Покупка времени");
        Label label = new Label("Выберите ваш тариф");
        label.setTextFill(Color.LIGHTBLUE);
        label.setStyle("-fx-font-weight: bold");
        label.setFont(new Font(18));
        Label label1 = new Label("Текущий тариф - 120 рублей");
        label1.setTextFill(Color.LIGHTBLUE);
        label1.setStyle("-fx-font-weight: bold");
        label1.setFont(new Font(18));
        TextField textField = new TextField();
        textField.setPromptText("Введите депозит");
        textField.setMaxSize(120, 20);
        Label label2 = new Label("Доступно минут - 0");
        label2.setTextFill(Color.LIGHTBLUE);
        label2.setStyle("-fx-font-weight: bold");
        label2.setFont(new Font(15));
        Button vipBtn = new Button("VIP");
        vipBtn.setOnAction(actionEvent1 -> {
            tarif.set(120);
            label1.setText("Текущий тариф - 120 рублей");
        });
        Button standartBtn = new Button("STANDART");
        standartBtn.setOnAction(actionEvent1 -> {
            tarif.set(90);
            label1.setText("Текущий тариф - 90 рублей");
        });
        Button calcBtn = new Button("Посчитать");
        calcBtn.setOnAction(actionEvent1 -> {
            chislo = Integer.parseInt(textField.getText());
            if (chislo > getBalance()){
                Alert loginError = new Alert(Alert.AlertType.ERROR);
                loginError.setTitle("Ошибка");
                loginError.setHeaderText("Посмотрите на баланс");
                loginError.setContentText("Депозит больше доступного баланса");
                loginError.show();
            }
            else {
                double b = Double.parseDouble(textField.getText());
                double minutes = b / tarif.get();
                String formattedResult = String.format("%.2f", minutes);
                String[] parts = formattedResult.split(",");
                int hour = Integer.parseInt(parts[0]) * 60;
                int min = Integer.parseInt(parts[1]) * 60 / 100;
                sum = hour + min;
                label2.setText("Доступно минут - " + sum);
            }
        });
        Button okBtn = new Button("OK");
        okBtn.setOnAction(actionEvent1 -> {
            if (label2.getText().equals("Доступно минут - 0")){
                Alert loginError = new Alert(Alert.AlertType.ERROR);
                loginError.setTitle("Ошибка");
                loginError.setHeaderText("Депозит не введен");
                loginError.show();
            }
            else {
                timeLabel.setText(String.valueOf(sum));
                setBalance(getBalance() - chislo);
                balanceLabel.setText(String.valueOf(getBalance()));
                try {
                    db.updateBalance(getBalance(), userInfo.getUserID());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                stage.close();
            }
        });
        VBox layot = new VBox(10);
        layot.getChildren().addAll(label, label1, standartBtn, vipBtn, textField, calcBtn, label2, okBtn);
        layot.setAlignment(Pos.CENTER);
        layot.setStyle("-fx-background-color: #000022");
        Scene scene = new Scene(layot,500,300);
        stage.setScene(scene);
        stage.showAndWait();

    }



    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        fioLabel.setText(UserInfo.getFIO());
        String bal = "";
        bal = db.getBalance(userInfo.getUserID());
        if (bal.equals(null)){
            bal = "0";
        } else {
            Alert balError = new Alert(Alert.AlertType.ERROR);
            balError.setTitle("ОШИБКА!");
            balError.setHeaderText("Вы не можете зайти в аккаунт без сессии");
            balError.setContentText("Попросите админа создать вам сессию!");
            balError.show();
        }
        int a = Integer.parseInt(bal);
        setBalance(a);
        balanceLabel.setText(bal);
    }

}
