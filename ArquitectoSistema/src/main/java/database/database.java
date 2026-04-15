/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;

public class database {

    // Nombre del archivo de la base de datos
    // Al NO tener una ruta como C:/..., se creará en la raíz de tu proyecto
    private static final String DB_NAME = "inventario_usb.db";
    private static final String URL = "jdbc:sqlite:" + DB_NAME;

    // 1. Método para obtener la conexión
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // 2. Método para crear la estructura (Tablas)
    public static void inicializarEstructura() {
        // El SQL que define tu tabla (según tu imagen)
        String sql = "CREATE TABLE IF NOT EXISTS CATEGORIAMATERIAL ("
                + "CAT_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "CAT_NOMBRE TEXT NOT NULL"
                + ");";

        // Usamos try-with-resources para cerrar la conexión automáticamente
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("LOG: Base de datos verificada correctamente.");

        } catch (SQLException e) {
            System.err.println("ERROR al crear tablas: " + e.getMessage());
        }
    }
}