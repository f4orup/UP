package com.example.test2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ProductsController {

    @FXML
    private TableView<Product> productTable;

    @FXML
    private Button BackBtn;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<Product, String> productNameCol;

    @FXML
    private TableColumn<Product, Double> productPriceCol;

    @FXML
    private TableColumn<Product, Integer> productQuantityCol;

    @FXML
    private TextField PrName;

    @FXML
    private TextField PrPrice;

    @FXML
    private TextField PrQuan;


    ObservableList<Product> listM;

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

    productNameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("ProductName"));
    productQuantityCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("ProductQuantity"));
    productPriceCol.setCellValueFactory(new PropertyValueFactory<Product, Double>("ProductPrice"));

    listM = db.getProduct();
    productTable.setItems(listM);

        addBtn.setOnAction(event -> {
            try {
                db.addProduct(PrName.getText(), Integer.parseInt(PrQuan.getText()), Double.parseDouble(PrPrice.getText()));
                Alert loginError = new Alert(Alert.AlertType.INFORMATION);
                loginError.setTitle("УСПЕХ!");
                loginError.setHeaderText(null);
                loginError.setContentText("Вы смогли добавить товар!");
                loginError.showAndWait();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                Alert loginError = new Alert(Alert.AlertType.ERROR);
                loginError.setTitle("ОШИБКА!");
                loginError.setHeaderText("Вы не смогли добавить товар");
                loginError.setContentText("Проверьте свою БД!");
                loginError.showAndWait();
            }
        });
    }

    private void deleteProduct() {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            listM.remove(selectedProduct);
            db.deleteProductFromDB(selectedProduct);
        }
    }

    @FXML
    void deleteButton(ActionEvent actionEvent) throws SQLException,IOException, ClassNotFoundException{

        deleteButton.setOnAction(event -> deleteProduct());

    }

}
