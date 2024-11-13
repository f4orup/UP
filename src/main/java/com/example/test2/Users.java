package com.example.test2;

public class Users {
    int UserID;
    String FIO, Passport, Login;

    public Users(int userID, String fio, String passport, String login) {
        UserID = userID;
        FIO = fio;
        Passport = passport;
        Login = login;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPassport() {
        return Passport;
    }

    public void setPassport(String passport) {
        Passport = passport;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }
}
