package com.example.test2;

import java.sql.Date;
import java.sql.Time;

public class Broni {

    int BroniID, AdminID, UserID, ComputerID;
    Date Date;

    Time Time;

    public Broni(int broniID, Date date, Time time, int adminID, int userID, int computerID) {
        BroniID = broniID;
        Date = date;
        Time = time;
        AdminID = adminID;
        UserID = userID;
        ComputerID = computerID;
    }

    public int getBroniID() {
        return BroniID;
    }

    public void setBroniID(int broniID) {
        BroniID = broniID;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int adminID) {
        AdminID = adminID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getComputerID() {
        return ComputerID;
    }

    public void setComputerID(int computerID) {
        ComputerID = computerID;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public java.sql.Time getTime() {
        return Time;
    }

    public void setTime(java.sql.Time time) {
        Time = time;
    }

}
