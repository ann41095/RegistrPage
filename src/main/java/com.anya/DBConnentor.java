package com.anya;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnentor {
    private static Connection connection;
    private static void getConnection() {
        try {
        String username = "root";
        String password = "1234";
        String connectionUrl = "jdbc:mysql://localhost:3306/users";
        Class.forName("com.mysql.jdbc.Driver");
        DBConnentor.connection = DriverManager.getConnection(connectionUrl, username,password);
        } catch (Exception e) {
        e.printStackTrace();
    }
}


    public static Connection getDbConnection() {
        if(connection == null) {
            getConnection();
        }
        return connection;
    }
}




