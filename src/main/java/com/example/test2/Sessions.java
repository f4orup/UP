package com.example.test2;

import java.sql.Time;
import java.sql.Date;

public class Sessions {

    int RecordID, AdminID, UserID, ComputerID, Balance;
    Date Date;

    Time Time;

    public Sessions(int recordID, Date date, Time time, int adminID, int userID, int computerID, int balance) {
        RecordID = recordID;
        Date = date;
        Time = time;
        AdminID = adminID;
        UserID = userID;
        ComputerID = computerID;
        Balance = balance;
    }

    public int getRecordID() {
        return RecordID;
    }

    public void setRecordID(int recordID) {
        RecordID = recordID;
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

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
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
