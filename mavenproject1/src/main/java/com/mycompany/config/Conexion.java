package com.mycompany.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Docente
 */
public class Conexion {

    private static Connection con;
    private static final String URL = "jdbc:mysql://localhost:3306/bdejemplo";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
        return con;
    }

    public static void cerrarConexion() {
        try {
            if (!con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

}
