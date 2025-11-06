package com.prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexion {

    // 🔹 Datos de conexión — mejor declararlos como constantes
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // incluye el servicio/instancia
    private static final String USER = "PRUEBA";
    private static final String PASSWORD = "password";

    public static Connection conectar() {
        try {
            // 🔹 En JDBC moderno (ojdbc8+), no hace falta registrar el driver manualmente,
            // pero puedes dejarlo por compatibilidad:
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida correctamente.");
            return con;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
