package com.example.test2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.sql.*;

import static java.lang.Class.*;

public class DBHandler {
    private final String HOST = "127.0.0.1";
    private final String PORT = "3306";
    private final String DB_NAME = "dbsych";
    private final String LOGIN = "root";
    private final String PASS = "root";
    private Connection dbConn = null;
    //"?serverTimezone=Europe/Moscow?characterEncoding=UTF8&useLegacyDatetimeCode=false"
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        forName("com.mysql.cj.jdbc.Driver");
        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);

       return dbConn;

        }


    public int checkUs(String Login, String Password) throws SQLException, ClassNotFoundException {
        int checked = -1;
        String query = "SELECT UserID FROM users WHERE Login = ? AND Passw = ?";
getDbConnection();

        PreparedStatement prst=getDbConnection().prepareStatement(query);

        prst.setString(1, Login);
        prst.setString(2, Password);
        ResultSet rs = prst.executeQuery();
        while (rs.next()){
            checked = rs.getInt("UserID");
        }
        rs.close();
        return checked;
    }

    public int checkUs1(String Login, String Password) throws SQLException, ClassNotFoundException {
        int checked = -1;
        String query = "SELECT AdminID FROM admins WHERE Login = ? AND Password = ?";
        getDbConnection();

        PreparedStatement prst=getDbConnection().prepareStatement(query);

        prst.setString(1, Login);
        prst.setString(2, Password);
        ResultSet rs = prst.executeQuery();
        while (rs.next()){
            checked = rs.getInt("AdminID");
        }
        rs.close();
        return checked;
    }

    public String userFIObyID(int id) throws SQLException, ClassNotFoundException{
        String FIO = null;
        String query = "Select FIO FROM users WHERE UserID = ?";
        PreparedStatement prst = getDbConnection().prepareStatement(query);

        prst.setInt(1, id);
        ResultSet rs = prst.executeQuery();
        while (rs.next()){
            FIO = rs.getString("FIO");
        }
        return FIO;
    }

    public String userFIObyID1(int id) throws SQLException, ClassNotFoundException{
        String FIO = null;
        String query = "Select FIO FROM admins WHERE AdminID = ?";
        PreparedStatement prst = getDbConnection().prepareStatement(query);

        prst.setInt(1, id);
        ResultSet rs = prst.executeQuery();
        while (rs.next()){
            FIO = rs.getString("FIO");
        }
        return FIO;
    }

    public void userReg(String FIO, String Passport, String Login, String Passw) throws SQLException, ClassNotFoundException{

        String query = "INSERT INTO users (UserID, FIO, Passport, Login, Passw) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement prst = getDbConnection().prepareStatement(query);
        prst.setInt(1, getUsersCount() + 1);
        prst.setString(2, FIO);
        prst.setString(3, Passport);
        prst.setString(4, Login);
        prst.setString(5, Passw);
        prst.executeUpdate();
        prst.close();
    }

    public int getUsersCount() throws SQLException, ClassNotFoundException {
        int count = 0;
        String query = "SELECT COUNT(*) count FROM users";
        PreparedStatement prst = getDbConnection().prepareStatement(query);
        ResultSet rs = prst.executeQuery();
        while (rs.next()) {
            count = rs.getInt("count");
        }
        return count;
    }

    public ObservableList<Product> getProduct() throws SQLException, ClassNotFoundException{
        ObservableList<Product> list = FXCollections.observableArrayList();
        try {
            PreparedStatement prst = getDbConnection().prepareStatement
                    ("SELECT ProductName, ProductQuantity, ProductPrice FROM products");
            ResultSet rs = prst.executeQuery();

            while (rs.next()){
                list.add(new Product(rs.getString("ProductName"), Integer.parseInt
                        (rs.getString("ProductQuantity")), Double.parseDouble(rs.getString
                        ("ProductPrice"))));
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }

    public int getProductIdMax() throws SQLException, ClassNotFoundException {
        int max_id = 0;
        String query = "SELECT MAX(ProductID) max_id FROM products";
        PreparedStatement prst = getDbConnection().prepareStatement(query);
        ResultSet rs = prst.executeQuery();
        while (rs.next()) {
            max_id = rs.getInt("max_id");
        }
        return max_id;
    }

    public void addProduct(String ProductName, int ProductQuantity, double ProductPrice) throws SQLException, ClassNotFoundException{

        String query = "INSERT INTO products (ProductID, ProductName, ProductQuantity, ProductPrice) VALUES (?, ?, ?, ?)";
        PreparedStatement prst = getDbConnection().prepareStatement(query);
        prst.setInt(1, getProductIdMax() + 1);
        prst.setString(2, ProductName);
        prst.setInt(3, ProductQuantity);
        prst.setDouble(4, ProductPrice);
        prst.executeUpdate();
        prst.close();
    }

    public void deleteProductFromDB(Product product) {
        try {
            String query = "DELETE FROM products WHERE ProductName = ?";
            PreparedStatement prst = getDbConnection().prepareStatement(query);
            prst.setString(1, product.getProductName());
            prst.executeUpdate();
            prst.close();
            getDbConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSession(Date date, Time time, int AdminID, int UserID, int ComputerID, int Balance) throws SQLException, ClassNotFoundException{
       String query = "INSERT INTO record (date, time, AdminID, UserID, ComputerID, Balance) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement prst = getDbConnection().prepareStatement(query);
        prst.setDate(1, date);
        prst.setTime(2, time);
        prst.setInt(3, AdminID);
        prst.setInt(4, UserID);
        prst.setInt(5, ComputerID);
        prst.setInt(6, Balance);
        prst.executeUpdate();
        prst.close();
    }


    public ObservableList<Users> getUsersInfo() throws SQLException, ClassNotFoundException{
        ObservableList<Users> list = FXCollections.observableArrayList();
        try {
            PreparedStatement prst = getDbConnection().prepareStatement
                    ("SELECT UserID, FIO, Passport, Login FROM users");
            ResultSet rs = prst.executeQuery();

            while (rs.next()){
                list.add(new Users(Integer.parseInt(rs.getString("UserID")), rs.getString("FIO"), rs.getString("Passport"), rs.getString("Login")));
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }

    public ObservableList<Sessions> getSessionInfo() throws SQLException, ClassNotFoundException{
        ObservableList<Sessions> list = FXCollections.observableArrayList();
        try {
            PreparedStatement prst = getDbConnection().prepareStatement
                    ("SELECT * FROM record");
            ResultSet rs = prst.executeQuery();

            while (rs.next()){
                list.add(new Sessions(Integer.parseInt(rs.getString("RecordID")), Date.valueOf(rs.getString("Date")), Time.valueOf(rs.getString("Time")),
                        Integer.parseInt(rs.getString("AdminID")), Integer.parseInt(rs.getString("UserID")),
                        Integer.parseInt(rs.getString("ComputerID")), Integer.parseInt(rs.getString("Balance"))));
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }

    public  ObservableList<String> getGenres() throws  SQLException, ClassNotFoundException{
        ObservableList<String> list = FXCollections.observableArrayList();
        String query = "SELECT DISTINCT Genre FROM games";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            list.add(rs.getString("Genre"));
        }
        rs.close();
        return list;
    }

    public String gameInfo(String Name) throws SQLException, ClassNotFoundException{
        String Genre = null;
        String query = "select Genre from games where Name = ?";
        PreparedStatement prst = getDbConnection().prepareStatement(query);

        prst.setString(1, Name);
        ResultSet rs = prst.executeQuery();
        while (rs.next()){
            Genre = rs.getString("Genre");
        }
        return Genre;
    }

    public String getBalance(int ID) throws SQLException, ClassNotFoundException{
        String Balance = "";
        String query = "select Balance from record where UserID = ?";
        PreparedStatement prst = getDbConnection().prepareStatement(query);

        prst.setInt(1, ID);
        ResultSet rs = prst.executeQuery();
        while (rs.next()){
            Balance = rs.getString("Balance");
        }
        return Balance;
    }

    public void updateBalance(int Balance, int UserID) throws SQLException, ClassNotFoundException {
        int newQuantity = Balance;
        String update = "UPDATE record SET Balance = ? WHERE UserID = ?";
        PreparedStatement preparedStatement1 = getDbConnection().prepareStatement(update);
        preparedStatement1.setInt(1, newQuantity);
        preparedStatement1.setInt(2, UserID);
        preparedStatement1.executeUpdate();
        preparedStatement1.close();
    }

    public void addBroni(Date date, Time time, int AdminID, int UserID, int ComputerID) throws SQLException, ClassNotFoundException{
        String query = "INSERT INTO broni (date, time, AdminID, UserID, ComputerID) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement prst = getDbConnection().prepareStatement(query);
        prst.setDate(1, date);
        prst.setTime(2, time);
        prst.setInt(3, AdminID);
        prst.setInt(4, UserID);
        prst.setInt(5, ComputerID);
        prst.executeUpdate();
        prst.close();
    }

    public ObservableList<Broni> getBroniInfo() throws SQLException, ClassNotFoundException{
        ObservableList<Broni> list = FXCollections.observableArrayList();
        try {
            PreparedStatement prst = getDbConnection().prepareStatement
                    ("SELECT * FROM broni");
            ResultSet rs = prst.executeQuery();

            while (rs.next()){
                list.add(new Broni(Integer.parseInt(rs.getString("BroniID")), Date.valueOf(rs.getString("Date")), Time.valueOf(rs.getString("Time")),
                        Integer.parseInt(rs.getString("AdminID")), Integer.parseInt(rs.getString("UserID")),
                        Integer.parseInt(rs.getString("ComputerID"))));
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }

    public int proverkaBroni(int ID) throws SQLException, ClassNotFoundException{
        int count = 0;
        String query = "select count(*) from record, broni where record.UserID = broni.UserID and record.Date >= broni.Date and record.Time >= broni.Time and record.UserID = ?";
        PreparedStatement prst = getDbConnection().prepareStatement(query);

        prst.setInt(1, ID);
        ResultSet rs = prst.executeQuery();
        while (rs.next()){
            count = rs.getInt("count(*)");
        }
        return count;
    }

    public void delFromBroni(int ID) throws SQLException, ClassNotFoundException{
        String query = "delete from broni where UserID = ?";
        PreparedStatement prst = getDbConnection().prepareStatement(query);
        prst.setInt(1, ID);
        prst.executeUpdate();
        prst.close();
    }

    public void delFromRecord(int ID) throws SQLException, ClassNotFoundException{
        String query = "delete from record where UserID = ?";
        PreparedStatement prst = getDbConnection().prepareStatement(query);
        prst.setInt(1, ID);
        prst.executeUpdate();
        prst.close();
    }

}
