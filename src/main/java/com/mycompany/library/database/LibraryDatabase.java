package com.mycompany.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibraryDatabase {

    static PreparedStatement preparedStatement;

    //function connected to the private getConnected function
    public static Connection getConnection(){
        return getConnected();
    }

    private static Connection getConnected() {
        
        String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12774281?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "sql12774281";
        String password = "ANA1SUkuem";
        
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
/*
    To Access MYSQL in XAMPP or TERMINAL
    use mysql -h [hostname]-u [username]-p 

    USE:
mysql -h sql12.freesqldatabase.com -u sql12774281 -p

    PASS:
    ANA1SUkuem
    */
