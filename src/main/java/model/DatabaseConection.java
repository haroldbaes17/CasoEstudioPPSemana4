package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConection {

    private static final String URL = "jdbc:mysql://srv863.hstgr.io/u484426513_pooc125";
    private static final String USER = "u484426513_pooc125";
    private static final String PASSWORD = "]Eq317KX6i*";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) {
//        Connection con = getConnection();
//
//        if (con != null) {
//            System.out.println("Conexion establecida");
//        } else {
//            System.err.println("No se conectó");
//        }
//    }
}
