package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConection {

    private static final String URL = "jdbc:mysql://localhost:3306/prograpatronescasoestudiosem4";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    public static void main(String[] args) {
        Connection con = getConnection();

        if (con != null) {
            System.out.println("Conexion establecida");
        } else {
            System.err.println("No se conectó");
        }
    }
    */
}
