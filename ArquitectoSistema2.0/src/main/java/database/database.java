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
    private static final String DB_NAME = "inventario_usb.db";
    private static final String URL = "jdbc:sqlite:" + DB_NAME;

    // 1. Método para obtener la conexión
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // 2. Método para crear la estructura (Tablas)
    public static void inicializarEstructura() {
        // 1. Activar llaves foráneas (Importante para mantener integridad)
        String pragma = "PRAGMA foreign_keys = ON;";

        // 2. Tabla CATEGORIAMATERIAL (versión COMPLETA con todos los campos)
        String tablaCategoria = "CREATE TABLE IF NOT EXISTS CATEGORIAMATERIAL ("
                + "CAT_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "CAT_NOMBRE TEXT NOT NULL, "
                + "CAT_UNIDAD1 TEXT NOT NULL, "
                + "CAT_PU REAL NOT NULL, "
                + "CAT_UNIDAD2 TEXT NOT NULL, "
                + "CAT_PU2 REAL NOT NULL, "
                + "CAT_CATEGORIA TEXT NOT NULL"
                + ");";

        // 3. Tabla MATERIAL (Hija de Categoría)
        String tablaMaterial = "CREATE TABLE IF NOT EXISTS MATERIAL ("
                + "MAT_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "MAT_NOMBRE VARCHAR(70) NOT NULL,"
                + "CAT_ID INTEGER,"
                + "MAT_UNIDADMIN VARCHAR(70),"
                + "MAT_UNIDADMINPRECIO REAL,"
                + "MAT_UNIDADMAX VARCHAR(70),"
                + "MAT_UNIDADMAXPRECIO REAL,"
                + "FOREIGN KEY (CAT_ID) REFERENCES CATEGORIAMATERIAL(CAT_ID)"
                + ");";

        // 4. Tabla SECCION
        String tablaSeccion = "CREATE TABLE IF NOT EXISTS SECCION ("
                + "SECC_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "SECC_NOMBRE VARCHAR(50) NOT NULL"
                + ");";

        // 5. Tabla CONCEPTO (Hija de Sección)
        String tablaConcepto = "CREATE TABLE IF NOT EXISTS CONCEPTO ("
                + "CONC_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "CONC_DESCRIPCION VARCHAR(400),"
                + "SECC_ID INTEGER,"
                + "CONC_CLAVE INTEGER,"
                + "CONC_UNIDAD VARCHAR(50),"
                + "CONC_PRECIOUNITARIO REAL,"
                + "FOREIGN KEY (SECC_ID) REFERENCES SECCION(SECC_ID)"
                + ");";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(pragma);
            stmt.execute(tablaCategoria);
            stmt.execute(tablaMaterial);
            stmt.execute(tablaSeccion);
            stmt.execute(tablaConcepto);
            System.out.println("LOG: Esquema completo verificado/creado con éxito.");
        } catch (SQLException e) {
            System.err.println("ERROR al inicializar esquema: " + e.getMessage());
        }
    }

    // Método para actualizar la tabla (si es necesario)
    public static void actualizacionTabla() {
        String sql = "ALTER TABLE CATEGORIAMATERIAL ADD COLUMN CAT_CATEGORIA TEXT;";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("LOG: Base de datos actualizada correctamente.");
        } catch (SQLException e) {
            System.err.println("ERROR al actualizar tabla: " + e.getMessage());
        }
    }
}
