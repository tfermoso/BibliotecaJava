package com.formacom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conectar(){
        String url="jdbc:mysql://localhost:3306/biblioteca";
        String user="root";
        String pass="";

        try {
            Connection conn= DriverManager.getConnection(url,user,pass);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
