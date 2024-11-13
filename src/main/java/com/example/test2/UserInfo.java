package com.example.test2;

public class UserInfo {

    private static String FIO;
    private static int UserID;
    private static int role;

    public static String getFIO() {
        return FIO;
    }

    public static void setFIO(String FIO) {
        UserInfo.FIO = FIO;
    }

    public static int getRole() {
        return role;
    }

    public static void setRole(int role) {
        UserInfo.role = role;
    }

    public static int getUserID() {
        return UserID;
    }

    public static void setUserID(int userID) {
        UserID = userID;
    }
}
